package com.sun.queue;

import java.util.Scanner;

/**
 * 使用数组模拟队列编写ArrayQueue类
 * 如何实现复用
 * @author Administrator
 *
 */
public class ArrayQueue {

	private int maxSize;  //表示数组最大容量
	private int rear;   //队列头
	private int front;  //队列尾
	private int[] arr;  //该数据用于存放数据，模拟队列
	
	//创建队列的构造器
	public ArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		front = -1;  //指向队列头部，分析出front是指向队列头的前一个位置
		rear = -1;  //指向队列尾部，指向队列尾的数据（即是队列最后一个数据）
	}
	
	//判断队列是否满
	public boolean isFull() {
		return rear == maxSize-1;
	}
	
	//判断队列是否空
	public boolean isEmpty() {
		return rear == front;
	}
	
	//添加数据到队列
	public void addQueue(int n) {
		//判断队列是否满意
		if(isFull()) {
			System.out.println("队列满，不能加入数据。。。。。");
			return;
		}
		rear++;
		arr[rear] = n;
	}

	//获取队列的数据，出队列
	public int getQueue() {
		//判断队列是否空
		if(isEmpty()) {
			//抛异常
			throw new RuntimeException("队列空，不能取数据。");
		}
		front++;//front后移
		return arr[front];
	}
	
	//显示队列的所有数据
	public void showQueue() {
		
		if(isEmpty()) {
			System.out.println("队列空的，没有数据.....");
			return ;
		}
		//遍历
		for(int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d]=%d\n",i,arr[i]);
		}
	}
	
	//显示队列的头数据，不是取数据
	public int headQueue() {
		//判断
		if(isEmpty()) {
			throw new RuntimeException();
		}
		return arr[front + 1];
	}
	
	public static void main(String[] args) {
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';  //接受用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get:从队列取数据)");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0); //接受一个字符
			switch(key) {
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("输入一个数字");
				int value = scanner.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.printf("取出的数据是%d\n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				try {
					int res = arrayQueue.headQueue();
					System.out.printf("取出的队列头数据是%d\n",res);
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				arrayQueue.showQueue();
				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出");
	}
}
