package store;

public class worker {
	int id; // 사원번호
	int pay; // 시급
	int workStart; // 시작 시간
	int workEnd; // 끝난 시간
	int workTime; // 근무시간
	
	// 근무 시작
	void setWorkStart(int time) {
		this.workStart = time;
	}  
	
	// 근무 종료
	void setWorkEnd(int time){
		this.workEnd = time;
		this.workTime = this.workEnd - this.workStart;
	}
	
}
