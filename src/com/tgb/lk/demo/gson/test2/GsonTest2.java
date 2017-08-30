package com.tgb.lk.demo.gson.test2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class GsonTest2 {

	public static void main(String[] args) {
		//ע�������Gson�Ĺ�����ʽΪGsonBuilder,������test1�е�Gson gson = new Gson();
		Gson gson = new GsonBuilder()
		.excludeFieldsWithoutExposeAnnotation() //������ʵ����û����@Exposeע�������
        .enableComplexMapKeySerialization() //֧��Map��keyΪ���Ӷ������ʽ
        .serializeNulls().setDateFormat("yyyy-MM-dd HH:mm:ss:SSS")//ʱ��ת��Ϊ�ض���ʽ  
        .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)//����ֶ�����ĸ��д,ע:����ʵ����ʹ����@SerializedNameע��Ĳ�����Ч.
        .setPrettyPrinting() //��json�����ʽ��.
        .setVersion(1.0)    //�е��ֶβ���һ��ʼ���е�,�����Ű汾��������ӽ���,��ô�ڽ������л��ͷ����л���ʱ��ͻ���ݰ汾����ѡ���Ƿ�Ҫ���л�.
        					//@Since(�汾��)��������ʵ���������.�����ֶο���,���Ű汾��������ɾ��,��ô
        					//@Until(�汾��)Ҳ��ʵ���������,GsonBuilder.setVersion(double)������Ҫ����.
        .create();
		
		

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
		
	}
}
