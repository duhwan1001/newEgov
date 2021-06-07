/**
 * pagination list up 함수
 * 
 * @param page
 *            페이지 번호
 * @param url
 *            list url
 */
function list_go(page, url) {

	if (!url)
		url = "list.do";

	var jobForm = $('#jobForm');
	// $('input[name="perPageNum"]').val($('select#perPageNum').val());
	jobForm.find("[name = 'page']").val(page);
	jobForm.find("[name = 'perPageNum']").val(
			$('select[name="perPageNum"]').val());
	jobForm.find("[name = 'searchType']").val(
			$('select[name="searchType"]').val());
	jobForm.find("[name = 'keyword']").val(
			$('div.input-group > input[name="keyword"]').val());

	$('form#jobForm').attr({
		action : 'list.do',
		method : 'get'
	}).submit();
}

/**
 * 팝업창 띄우기
 * 
 * @param UrlStr
 *            주소
 * @param WinTitle
 *            타이틀
 * @param WinWidth
 *            넓이
 * @param WinHeight
 *            길이
 */
function OpenWindow(UrlStr, WinTitle, WinWidth, WinHeight) {
	winleft = (screen.width - WinWidth) / 2;
	wintop = (screen.height - WinHeight) / 2;
	var win = window.open(UrlStr, WinTitle, "scroolbars=yes,width=" + WinWidth
			+ "," + "height=" + WinHeight + ", top=" + wintop + ", left="
			+ winleft + ", resizable=yes, status=yes");
	win.focus();
}

function CloseWindow(parentURL) {
	if (parentURL) {
		window.opener.parent.location.href = parentURL;
	} else {
		window.opener.location.reload(true);
	}
	window.close();

}
function MemberPictureThumb(targetObj, fileName) {
	targetObj.style.backgroundImage = "url('getPicture.do?picture=" + fileName + "')";
	targetObj.style.backgroundPosition = "center";
	targetObj.style.backgroundRepeat = "no-repeat";
	targetObj.style.backgroundSize = "cover";
}


// modify.jsp 전용
var picture = document.getElementById("pictureView");
getPicture(picture, '${member.picture}');

function getPicture(targetObj, fileName){
	targetObj.style.backgroundImage="url('getPicture.do?picture="+fileName+"')";
	targetObj.style.backgroundPosition="center";
	targetObj.style.backgroundRepeat="no-repeat";
	targetObj.style.backgroundSize="cover";
}
// end

