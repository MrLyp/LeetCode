package com.robbie;

public class Relations {

    static class Node {
        private String name;

        private Node father;

        private Node mother;

        private Node son;

        private Node daughter;

        private Node brother;

        private Node sister;

        public Node(String name) {
            this.name = name;
        }

        public Node getFather() {
            return father;
        }

        public Node getMother() {
            return mother;
        }

        public Node getSon() {
            return son;
        }

        public Node getDaughter() {
            return daughter;
        }

        public Node getBrother() {
            return brother;
        }

        public Node getSister() {
            return sister;
        }
    }

    static class NodeFactory {

        public Node addFather(Node me, Node father) {
            me.father = father;
            return me;
        }

        public Node addMother(Node me, Node mother) {
            me.mother = mother;
            return me;
        }

        public Node addBrother(Node me, Node brother) {
            me.brother = brother;
            return me;
        }

        public Node addSister(Node me, Node sister) {
            me.sister = sister;
            return me;
        }

        public Node addSon(Node me, Node son) {
            me.son = son;
            return me;
        }

        public Node addDaughter(Node me, Node daughter) {
            me.daughter = daughter;
            return me;
        }

        public Node find(Node me, String relation) {
            switch (relation) {
                case "父":
                    return me.getFather();
                case "母":
                    return me.getMother();
                case "兄":
                    return me.getBrother();
                case "姐":
                    return me.getSister();
                case "我":
                    return me;
                default:
                    return null;
            }
        }

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
            addSon(father, me);
            addDaughter(father, sister);
            addFather(father, grandfather);
            addMother(father, grandmother);

            // 妈妈的关系链
            addSon(mother, me);
            addDaughter(mother, me);
            addFather(mother, grandfather);
            addMother(mother, grandmother);

            // 兄弟的关系链
            addSon(father, brother);
            addFather(brother, father);
            addMother(brother, mother);
            addSister(brother, sister);

            // 姐妹的关系链
            addFather(sister, father);
            addMother(sister, mother);
            addBrother(sister, brother);

            // 儿子的关系链
            addSon(me, son);
            addSon(son, grandson);
            addFather(son, me);


            // 女儿的关系链
            addDaughter(me, daughter);
            addFather(daughter, me);

            // 自己的关系链
            addSister(me, sister);
            addBrother(me, brother);
            addFather(me, father);
            addMother(me, mother);
            addSister(me, son);
            addDaughter(me, daughter);

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

        String calculate(String pattern) {
            String[] array = pattern.split("的");
            Node node = me;
            for (String relation : array) {
                node = factory.find(node, relation);
                if (node == null) {
                    break;
                }
            }
            if (node == null)
                return "未知";
            else
                return node.name;
        }

        boolean search() {
            return false;
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        String result = calculator.calculate("我的父的父");
        System.out.println(result);
        result = calculator.calculate("我的父的母");
        System.out.println(result);
        result = calculator.calculate("我的父的兄");
        System.out.println(result);
    }

}
