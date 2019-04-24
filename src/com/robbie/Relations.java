package com.robbie;

import java.util.*;

/**
 * 一个简单的亲戚计算器。解决思路是构建一个亲戚图，每个人是其中的一个节点，节点之间的边代表亲戚关系，并且是双向联系。构建亲戚图谱之后，所有的操作均基于该图进行。
 * 目前亲戚图谱的构建只有几个简单的关系， 这里只是一个简单的示意。如需扩展至需要按照规则增加节点和连线即可
 *
 * 1. 亲戚关系的计算即是在这个图上按照给定的进行查找
 * 2. 判断两个人是否满足特定关系即只需要判断两个节点之间是否存在连线
 * 3. 查找一个人的所有关系即以这个节点出发所指向的节点
 * */
public class Relations {

    static class Node {

        private static final String KEY_FATHER = "父";
        private static final String KEY_MOTHER = "母";
        private static final String KEY_SISTER = "姐";
        private static final String KEY_BROTHER = "兄";
        private static final String KEY_SON = "子";
        private static final String KEY_DAUGHTER = "女";
        private static final String KEY_ME = "我";

        private String name;

        private Map<String, List<Node>> relations = new HashMap<>();

        public Node(String name) {
            this.name = name;
        }

        public Node setMe(Node me) {
            return bindRelation(me, KEY_ME);
        }

        public Node setFather(Node father) {
            return bindRelation(father, KEY_FATHER);
        }

        public Node setMother(Node mother) {
            return bindRelation(mother, KEY_MOTHER);
        }

        public Node setBrother(Node brother) {
            return bindRelation(brother, KEY_BROTHER);
        }

        public Node setSister(Node sister) {
            return bindRelation(sister, KEY_SISTER);
        }

        public Node setSon(Node son) {
            return bindRelation(son, KEY_SON);
        }

        public Node setDaughter(Node daughter) {
            return bindRelation(daughter, KEY_DAUGHTER);
        }

        private Node bindRelation(Node node, String key) {
            List<Node> list = relations.get(key);
            if (list == null)
                list = new ArrayList<>();
            list.add(node);
            relations.put(key, list);
            return this;
        }

        public List<Node> getRelation(String relation) {
            return relations.get(relation);
        }
    }

    static class NodeFactory {

        /**
         * 构建关系图谱
         * */
        public Node buildTree() {
            Node me = new Node("我");
            Node father = new Node("爸爸");
            Node mother = new Node("妈妈");
            Node sister = new Node("姐姐");
            Node brother = new Node("哥哥");
            Node son = new Node("儿子");
            Node daughter = new Node("女儿");
            Node grandfather = new Node("爷爷");
            Node grandmother = new Node("奶奶");
            Node grandson = new Node("孙子");
            Node granddaughter = new Node("孙女");

            // 爸爸的关系链
            father.setSon(me);
            father.setSon(brother);
            father.setDaughter(me);
            father.setDaughter(sister);
            father.setFather(grandfather);
            father.setMother(grandmother);


            // 妈妈的关系链
            mother.setSon(me);
            mother.setDaughter(me);
            mother.setSon(brother);
            mother.setDaughter(sister);
            mother.setFather(grandfather);
            mother.setMother(grandmother);

            // 兄弟的关系链
            brother.setFather(father);
            brother.setMother(mother);
            brother.setBrother(me);
            brother.setSister(sister);

            // 姐妹的关系链
            sister.setFather(father);
            sister.setMother(mother);
            sister.setBrother(me);
            sister.setSister(me);

            // 儿子的关系链
            son.setFather(me);
            son.setMother(me);
            son.setSister(daughter);
            son.setSon(grandson);
            son.setDaughter(granddaughter);

            // 女儿的关系链
            daughter.setFather(me);
            daughter.setMother(me);
            daughter.setBrother(son);
            daughter.setSon(grandson);
            daughter.setDaughter(granddaughter);

            // 孙子的关系链
            grandson.setFather(son);
            grandson.setMother(daughter);
            grandson.setSister(granddaughter);

            // 孙女的关系链
            granddaughter.setFather(son);
            granddaughter.setMother(daughter);
            granddaughter.setBrother(grandson);


            // 自己的关系链
            me.setFather(father);
            me.setMother(mother);
            me.setBrother(brother);
            me.setSister(sister);
            me.setSon(son);
            me.setDaughter(daughter);
            me.setMe(me);

            return me;
        }
    }

    static class Calculator {

        private Node me;

        private NodeFactory factory;

        public Calculator() {
            factory = new NodeFactory();
            me = factory.buildTree();
        }

        /**
         * 计算亲戚关系,这里的特殊地方是【我】的身份未知，所以类似父亲的儿子可能是我自己，也可能是我的兄弟，这里取并集
         *
         * @param pattern 期望计算的亲戚关系，以【的】进行分隔。
         * @return 返回亲戚关系，如果无法计算则返回【未知】
         * */
        String calculate(String pattern) {
            String[] array = pattern.split("的");
            List<Node> list = new ArrayList<>();
            list.add(me);
            for (String relation : array) {
                List<Node> tmp = new ArrayList<>();
                for (Node node: list) {
                    List<Node> relations = node.getRelation(relation);
                    if (relations != null && relations.size() > 0) {
                        tmp.addAll(relations);
                    }
                }
                list = tmp;
            }
            Set<Node> set = new HashSet<>(list);
            if (set.isEmpty())
                return "未知";
            else {
                Iterator<Node> iterator = set.iterator();
                StringBuilder result = new StringBuilder();
                while (iterator.hasNext()) {
                    if (result.length() > 0)
                        result.append("或");
                    result.append(iterator.next().name);
                }
                return result.toString();
            }
        }

        /**
         * 判断两个节点是否存在父子关系，如果需要判断其他关系的话思路类似
         * @param father 父亲节点
         * @param son 孩子节点
         * @return 如果是父子节点，则返回true，否则返回false
         * */
        boolean isFatherOrSon(Node father, Node son) {
            List<Node> sonList = father.getRelation(Node.KEY_SON);
            if (sonList != null && sonList.contains(son))
                return true;
            List<Node> fatherList = son.getRelation(Node.KEY_FATHER);
            if (fatherList != null && fatherList.contains(father))
                return true;
            return false;
        }

        /**
         * 获取某个节点的所有关系节点，父母只有一个节点，但是兄弟姐妹可能有多个
         * */
        List<Node> getRelations(Node node, String relation) {
            return node.getRelation(relation);
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        // 爷爷
        String result = calculator.calculate("我的父的父");
        System.out.println(result);

        // 奶奶
        result = calculator.calculate("我的父的母");
        System.out.println(result);

        // 姐姐或者我自己
        result = calculator.calculate("我的父的女");
        System.out.println(result);

        // 其实应该是外公，但是这里为了简单以爷爷代替
        result = calculator.calculate("我的父的女的母的父");
        System.out.println(result);

        // 叔叔，但是目前没有这个关系，所以返回未知
        result = calculator.calculate("我的父的兄");
        System.out.println(result);
    }

}
