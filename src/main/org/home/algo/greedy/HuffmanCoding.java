package org.home.algo.greedy;

import java.util.*;

/**
 * The class is for Hoffman Encoding
 */
public class HuffmanCoding {
    /**
     * The priority queue to build heap.
     * The queue take {@link CharacterFrequencyComparator} as the comparator
     * to maintain heap property.
     */
    PriorityQueue<HuffmanNode> huffmanHeap;

    public HuffmanCoding() {
        this.huffmanHeap = new PriorityQueue<>(new CharacterFrequencyComparator());
    }

    public void addCharacter(HuffmanNode chFreq){
        huffmanHeap.add(chFreq);
    }

    public void addCharacters(List<HuffmanNode> chFreqList){
        if(chFreqList != null && chFreqList.size()>0){
            chFreqList.stream().forEach(e->addCharacter(e));
        }
    }

    /**
     * Create huffman tree.
     * Hoffman tree is constructed based on following logic:
     * <ol>
     *     <li> Sort the characters based on their frequency</li>
     * </ol>
     */
    private void buildHuffmanHeap(){
        if(huffmanHeap != null && huffmanHeap.size()>0){
            while (huffmanHeap.size()>1){
                HuffmanNode firstMin = huffmanHeap.poll();
                HuffmanNode secondMin = huffmanHeap.poll();
                huffmanHeap.add(new HuffmanNode(firstMin.getFrequency()+secondMin.getFrequency(),
                        false,firstMin,secondMin));

            }
        }
    }

    public void generateHuffmanCode(int[] frequencies, char[] characters){
        for(int i=0;i<frequencies.length;i++){
            addCharacter(new HuffmanNode(characters[i],frequencies[i]));
        }
        buildHuffmanHeap();
        assignCode();
    }

    public void printHeap(){
        if(huffmanHeap != null && huffmanHeap.size()>0){
            huffmanHeap.stream().forEach(e-> System.out.println(e));
        }
    }

    private void assignCode(){
        doAssignment(huffmanHeap.peek(),"");
    }

    private void doAssignment(HuffmanNode node, String s){
        if(node.isLeaf()){
            node.setCode(s);
        }else{
            doAssignment(node.getLeftChild(),s+"0");
            doAssignment(node.getRightChild(),s+"1");
        }
    }

    public void printHuffmanTree(){
        doPrint(huffmanHeap.peek());
    }

    private void doPrint(HuffmanNode node){
        if(node.isLeaf()){
            System.out.println(node);
        }else{
            doPrint(node.getLeftChild());
            doPrint(node.getRightChild());
        }
    }

    public List<HuffmanNode> collectNodesWithCode(){
        List<HuffmanNode> buckets = new ArrayList<>();
        doCollect(huffmanHeap.peek(),buckets);
        buckets.sort(new CharacterFrequencyComparator());
        return buckets;
    }

    private void doCollect(HuffmanNode node, List<HuffmanNode> bucket){
        if(node.isLeaf()){
            bucket.add(node);
        }else{
            doCollect(node.getLeftChild(), bucket);
            doCollect(node.getRightChild(), bucket);
        }
    }

    public static void main(String[] args) {
        HuffmanCoding hufCode = new HuffmanCoding();
        int[] frequency = { 5,9,12,13,45,16};
        char[] characters = {'a','b','c','d','f','e'};
        for(int i=0;i<frequency.length;i++){
            hufCode.addCharacter(new HuffmanNode(characters[i],frequency[i]));
        }
        //hufCode.printHeap();
        hufCode.buildHuffmanHeap();
        hufCode.assignCode();
        hufCode.printHuffmanTree();
    }
}

class HuffmanNode {

    private Character ch;
    private Integer frequency;
    private Boolean leaf;
    private HuffmanNode leftChild;
    private HuffmanNode rightChild;
    private String code;

    public HuffmanNode(Character ch, Integer frequency) {
        this.ch = ch;
        this.frequency = frequency;
        leaf = true;
        leftChild = null;
        rightChild = null;
    }

    public HuffmanNode(Integer frequency, Boolean leaf, HuffmanNode leftChild, HuffmanNode rightChild) {
        this.frequency = frequency;
        this.leaf = leaf;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Character getCh() {
        return ch;
    }

    public void setCh(Character ch) {
        this.ch = ch;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    public Boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(Boolean leaf) {
        this.leaf = leaf;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HuffmanNode leftChild) {
        this.leftChild = leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HuffmanNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "ch=" + ch +
                ", frequency=" + frequency +
                ", leaf=" + leaf +
                ", code='" + code + '\'' +
                '}';
    }
}

class CharacterFrequencyComparator implements Comparator<HuffmanNode>{

    @Override
    public int compare(HuffmanNode o1, HuffmanNode o2) {
        return o1.getFrequency().compareTo(o2.getFrequency());
    }
}
