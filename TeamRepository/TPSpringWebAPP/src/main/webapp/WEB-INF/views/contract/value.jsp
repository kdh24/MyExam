<%@ page contentType="application/json; charset=UTF-8"%>

{
	"roomName" : "룸 계약정보",
	"text" : [ "온,습도", "불", "가스" , "카메라", "방문자" ],
	"contract": {
		"room" : "${roomName}",
		"temperature" : ["${contract.ctemperature}", "${contract.cfire}", "${contract.cgas}", "${contract.cview}", "${contract.cvisitor}"]
	}
}
