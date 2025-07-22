//이미지 배열 
let selectedFiles=[];

/*-----------------------------------------
이미지 초기화(삭제)
-----------------------------------------*/ 
function initImg(array){
	//이미지 제거 
	$("#preview").empty();
	
	//배열 제거 
	let n=array.length;
	for(let i=0;i<n;i++){
		selectedFiles.splice(0, 1);
	}
}

/*-----------------------------------------
이미지 등록 
-----------------------------------------*/
function addImg(e, array, container){
	console.log("삭제 전 배열 크기 ", array.length);
	
	let n=array.length;

	console.log("삭제 후 배열 크기 ", array.length);

	$(container).html(""); // 기존 이미지 초기화

	//let files = $("#photo").files;
	console.log("파일배열은 ", e.target.files);
	
	let files = e.target.files;
		
	for(let i=0;i<files.length;i++){
		const reader = new FileReader();
		
		selectedFiles[i]=files[i];	
		
		console.log(i,"번째 file은  ",selectedFiles[i]);
		
		reader.onload=function(e){
			console.log("읽음", e);					
			let productImg = new ProductImg(document.getElementById("preview"), selectedFiles[i] , e.target.result, 100,100);
		}				
		reader.readAsDataURL(files[i]);
	}
	console.log("임시로 담은 배열은 ", selectedFiles);
} 
