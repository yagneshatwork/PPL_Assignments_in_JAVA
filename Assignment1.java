class student
{
	private String studentID;
	private String name;
	private float oop,ds,deco,mfg;
		
	public void setStudentID(String studentID)  //set student id
	{
		this.studentID=studentID;
	}
	
	public void setName(String name)  //set name
	{
		this.name=name;
	}
	
	public void setMarks(float oop,float ds,float deco,float mfg)  //set marks
	{
		this.oop=oop;
		this.ds=ds;
		this.deco=deco;
		this.mfg=mfg;
	}
	
	public String getStudentID()  //get student id
	{
		return studentID;
	}
	
	public String getName()  //get name
	{
		return name;
	}
	
	public float getAverage() //get average
	{
		float total = ((oop + ds + deco + mfg)/400)*100;
		return total;
    }
		
	public void studentdisplay()  //display
	{
		float avg=getAverage();
		
		System.out.println("Student ID : "+studentID+"\n");
		System.out.println("Name :"+name+"\n");
		System.out.println("Marks : OOP  ="+oop);
		System.out.println("      : DS   ="+ds);
		System.out.println("      : DECO ="+deco);
		System.out.println("      : MFG  ="+mfg+"\n");
			
		if(oop<0||ds<0||deco<0||mfg<0)
		{
			System.out.println("Marks cannot be less then 0 or negative");
		}
		else if(oop>100||ds>100||deco>100||mfg>100)
		{
			System.out.println("Marks cannot be greater then 100");
		}
		else
		{
			System.out.println("Average :"+avg+"%\n");
			
			if(oop<50||ds<50||deco<50||mfg<50)
			{
				System.out.println("Result = Fail❌");
			}
			else
			{
				System.out.println("Result = Pass✅");
			}
		}
	}
}

class Assignment1
{
	public static void main(String[] args)  //main
	{
		student d = new student();
		
		d.setStudentID("B24CE1952");
		d.setName("Yagnesh");
		d.setMarks(55,-63,72,87);
		d.studentdisplay();
	}
}
		
