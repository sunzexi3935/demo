package com.sun.queue;

import java.util.Scanner;

public class CircleArrayQueue {

	private int maxSize;  //表示数组最大容量
	private int rear;   //队列头
	private int front;  //队列尾
	private int[] arr;  //该数据用于存放数据，模拟队列
	
	//创建队列的构造器
	public CircleArrayQueue(int arrMaxSize) {
		maxSize = arrMaxSize;
		arr = new int[maxSize];
		//front = -1;  //指向队列头部，分析出front是指向队列头的前一个位置
		//rear = -1;  //指向队列尾部，指向队列尾的数据（即是队列最后一个数据）
	}
	
	//判断队列是否满
	public boolean isFull() {
		//return rear == maxSize-1;
		return (rear + 1)%maxSize == front;
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
		//直接将数据加入
		arr[rear] = n;  
		//将rear后移，必须考虑取模
		rear = (rear + 1)% maxSize;
	}

	//获取队列的数据，出队列
	public int getQueue() {
		//判断队列是否空
		if(isEmpty()) {
			//抛异常
			throw new RuntimeException("队列空，不能取数据。");
		}
		//分析front是指向队列的第一个元素
		//1、先将front对应的值保留到一个临时变量
		//2、将front后移，考虑取模
		//3、将临时保存的变量返回
		int value = arr[front];
		front = (front + 1)%maxSize;
		return value;
	}
	
	//显示队列的所有数据
	public void showQueue() {
		
		if(isEmpty()) {
			System.out.println("队列空的，没有数据.....");
			return ;
		}
		//遍历
		//从front开始遍历
		for(int i = 0; i < front + size(); i++) {
			System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
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
	
	//求出当前队列的有效数据个数
	public int size() {
		return (rear + maxSize - front) % maxSize;
	}
	
	public static void main(String[] args) {
		//测试环形数组
		CircleArrayQueue arrayQueue = new CircleArrayQueue(3);
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
