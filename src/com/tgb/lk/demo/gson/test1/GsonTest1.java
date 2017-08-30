package com.tgb.lk.demo.gson.test1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class GsonTest1 {

	public static void main(String[] args) {
		Gson gson = new Gson();

		Student student1 = new Student();
		student1.setId(1);
		student1.setName("����");
		student1.setBirthDay(new Date());

		// //////////////////////////////////////////////////////////
		System.out.println("----------�򵥶���֮���ת��-------------");
		// �򵥵�beanתΪjson
		String s1 = gson.toJson(student1);
		System.out.println("��Beanת��ΪJson===" + s1);

		// jsonתΪ��Bean
		Student student = gson.fromJson(s1, Student.class);
		System.out.println("JsonתΪ��Bean===" + student);
		// ���:
		// ��Beanת��ΪJson==={"id":1,"name":"����","birthDay":"Jun 22, 2012 8:27:52 AM"}
		// JsonתΪ��Bean===Student [birthDay=Fri Jun 22 08:27:52 CST 2012, id=1,
		// name=����]
		// //////////////////////////////////////////////////////////

		Student student2 = new Student();
		student2.setId(2);
		student2.setName("�ܹ���");
		student2.setBirthDay(new Date());

		Student student3 = new Student();
		student3.setId(3);
		student3.setName("����");
		student3.setBirthDay(new Date());

		List<Student> list = new ArrayList<Student>();
		list.add(student1);
		list.add(student2);
		list.add(student3);

		System.out.println("----------�����͵�List֮���ת��-------------");
		// �����͵�listת��Ϊjson
		String s2 = gson.toJson(list);
		System.out.println("�����͵�listת��Ϊjson==" + s2);

		// jsonתΪ�����͵�list
		List<Student> retList = gson.fromJson(s2,
				new TypeToken<List<Student>>() {
				}.getType());
		for (Student stu : retList) {
			System.out.println(stu);
		}

		// ���:
		// �����͵�listת��Ϊjson==[{"id":1,"name":"����","birthDay":"Jun 22, 2012 8:28:52 AM"},{"id":2,"name":"�ܹ���","birthDay":"Jun 22, 2012 8:28:52 AM"},{"id":3,"name":"����","birthDay":"Jun 22, 2012 8:28:52 AM"}]
		// Student [birthDay=Fri Jun 22 08:28:52 CST 2012, id=1, name=����]
		// Student [birthDay=Fri Jun 22 08:28:52 CST 2012, id=2, name=�ܹ���]
		// Student [birthDay=Fri Jun 22 08:28:52 CST 2012, id=3, name=����]

	}
}
