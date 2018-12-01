package cn.glory.base;

import org.testng.annotations.Test;

//使用group关键字进行分组，执行多个测试用例
public class Grouping {
	
  @Test(groups = {"人"})
  public void student() {
	  System.out.println("学生方法被调用");
  }
  
  @Test(groups = {"人"})
  public void teacher() {
	 System.out.println("老师方法被调用"); 
  }
  
  @Test(groups = {"动物"})
  public void tiger() {
	  System.out.println("老虎方法被调用");
  }
  
  @Test(groups = {"动物"})
  public void panda() {
	  System.out.println("熊猫方法被调用");
  }
  
  @Test(groups = {"人","动物"})
  public void feeder() {
	  System.out.println("饲养员方法被调用");
  }
  
  
}
