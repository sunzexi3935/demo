package com.sun.linkedList;

/**
 * 链表
 * @author sunzexi
 *
 */
public class SingleLinkedListDemo {

	public static void main(String[] args) {
		
		SingleLinkedList singleLinkedList = new SingleLinkedList();
		
		HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
		HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
		HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
		HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");
		HeroNode hero8 = new HeroNode(8, "李逵", "黑旋风");
		
		/*
		singleLinkedList.add(hero1);
		singleLinkedList.add(hero2);
		singleLinkedList.add(hero3);
		singleLinkedList.add(hero4);
		*/
		
		singleLinkedList.addByOrder(hero8);
		singleLinkedList.addByOrder(hero1);
		singleLinkedList.addByOrder(hero3);
		singleLinkedList.addByOrder(hero2);
		singleLinkedList.addByOrder(hero4);
		
		singleLinkedList.list();
	}
	
}

//定义管理英雄
class SingleLinkedList{
	//初始化头节点，不存放数据
	private HeroNode head = new HeroNode(0, "", "");
	
	//第一种添加节点方式
	//添加节点到单向链表的尾部
	//1、找到当前链表的最后节点
	//2、将最后这个节点的next指向新的节点
	public void add(HeroNode heroNode) {
		//因为head节点不能动，因此我们需要一个辅助遍历temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while(true) {
			//找到链表的最后
			if(temp.next == null) {
				break;
			}
			//如果没有找到最后，就将temp后移
			temp = temp.next;
		}
		//当退出while循环时，temp就指向链表的最后
		//将最后这个节点的next指向新的节点
		temp.next = heroNode;
	}
	
	//第二种添加节点方式
	//添加英雄时根据排名添加到指定的位置
	public void addByOrder(HeroNode heroNode) {
		//因为头节点不能动，因此通过一个辅助指针（变量）来帮助找到添加的位置
		//因为单链表，所以我们找的temp是位于添加位置的前一个节点，否则插入不了
		HeroNode temp = head;
		boolean flag = false;  //标志添加的编号是否存在，默认为false
		while(true) {
			if(temp.next == null) {	//说明temp已经在链表的最后
				break;
			}
			if(temp.next.no > heroNode.no) {	//位置找到，就在temp的后面插入
				break;
			}else if(temp.next.no == heroNode.no) {	//说明希望添加的heroNode编号已经存在
				flag = true;
				break;
			}
			temp = temp.next;	//后移，遍历当前链表
		}
		//判断flag的值
		if(flag) {
			System.out.printf("准备插入的编号%d 已经存在，不能加入",heroNode.no);
		}else {
			heroNode.next = temp.next;
			temp.next = heroNode;
			System.out.println("插入成功。。。。。");
		}
	}
	
	//显示链表
	public void list() {
		//判断链表是否为空
		if(head.next == null) {
			System.out.println("链表为空。。。。");
			return;
		}
		//因为头节点，不能动，因此需要一个辅助遍历来遍历
		HeroNode temp = head.next;
		while(true) {
			//判断是否到链表最后
			if(temp == null) {
				break;
			}
			//输出节点的信息
			System.out.println(temp);
			//将temp后移
			temp = temp.next;
		}
	}
}

class HeroNode {
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;
	
	//构造器
	public HeroNode(int no,String name,String nickname) {
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	
	@Override
	public String toString() {
		return "HeroNode [no="+no+", name="+name+", nickname="+nickname+"]";
	}
}
