package com.bj.test;

import com.jpattern.javassist.CannotCompileException;
import com.jpattern.javassist.ClassPool;
import com.jpattern.javassist.CtClass;
import com.jpattern.javassist.CtConstructor;
import com.jpattern.javassist.CtField;
import com.jpattern.javassist.CtMethod;

public class Main {

	public static void main(String[] args) throws Exception {
		ClassPool pool = ClassPool.getDefault();
		
		//创建类
		CtClass ctc = pool.makeClass("com.bean.Emp");
		
		//创建属性
		CtField f1 = CtField.make("private int empno;", ctc);
		CtField f2 = CtField.make("private String ename;", ctc);
		ctc.addField(f1);
		ctc.addField(f2);
		
		//创建方法
		CtMethod m1 = CtMethod.make("public int getEmpno(){return empno;};",ctc);
		CtMethod m2 = CtMethod.make("public void setEmpno(int empno){this.empno=empno;};",ctc);
		ctc.addMethod(m1);
		ctc.addMethod(m2);
		
		//添加构造器
		CtConstructor constructor = new CtConstructor(new CtClass[]{CtClass.intType,pool.get("java.lang.String")}, ctc);
		constructor.setBody("{this.empno=empno;this.ename=ename;}");//添加构造器的方法体
		ctc.addConstructor(constructor);
		
		ctc.writeFile("d://demo/java");
		
		System.out.println("OK");
		
		
		
	}
}





























