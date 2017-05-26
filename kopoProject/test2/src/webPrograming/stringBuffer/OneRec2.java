package webPrograming.stringBuffer;

public class OneRec2 {
	private String name;
	private int kor;
	private int eng;
	private int mat;
	
	public OneRec2(int student_id, String name, int kor, int eng, int mat) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public int student_id(){return this.student_id();};
	public String mame() {return this.name;}
	public int kor() {return this.kor;}
	public int eng() {return this.eng;}
	public int mat() {return this.mat;}
	public int sum() {return this.kor+this.eng+this.mat;};
	public double ave(){return this.sum()/3.0;};
	
}
