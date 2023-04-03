
// 관리자 상품등록란 입력확인
function prdInsertcheck() {
//	alert("admin js");
	var name=$("input[name=p_name]").val();
	var price=$("input[name=p_price]").val();
	var cnt=$("input[name=p_cnt]").val();
	var color=$("input[name=p_color]").val();
	var size=$("input[name=p_size]").val();
	var file=$("input[name=p_filesrc]").val();
	var category=$("input[name=p_category]").val();
	var info=$("input[name=p_info]").val();
	if(name == "" || price == "" || cnt == "" || color == "" || size == "" ||
		file == "" || file == null || category == "" || info == ""){
		alert("상품 내용을 입력하세요")
		return false;
	}else {
		return true;
	}
}