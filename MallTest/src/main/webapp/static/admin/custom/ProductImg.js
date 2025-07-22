class ProductImg{
	constructor(container, file, src, width, height){
		this.container=container;
		this.file=file;
		this.wrapper=document.createElement("div");
		this.header=document.createElement("div");		
		this.img=document.createElement("img");
		this.src=src;
		this.width=width;
		this.height=height;
		
		//style 
		this.img.src=this.src;
		this.img.style.width=this.width+"px";
		this.img.style.height=this.height+"px";
					
		this.wrapper.style.width=this.width+"px";
		this.wrapper.style.height=(this.height+20)+"px";
		this.wrapper.style.display="inline-block";
		this.wrapper.style.float="left";
		this.wrapper.style.margin="2px";
		
		this.header.innerHTML="<a href='#'>X</a>";
		this.header.style.textAlign="left";
	
		//조립 
		this.wrapper.appendChild(this.header);		
		this.wrapper.appendChild(this.img);
		this.container.appendChild(this.wrapper);
		
		//이벤트 
		this.header.addEventListener("click", (e)=>{
			e.preventDefault();
			this.remove();
		});	
	}
	
	remove(){
		this.container.removeChild(this.wrapper);
		
		//전체 배열에서 삭제
		let index = selectedFiles.indexOf(this.file); 
		console.log("배열에서 발견된 파일의 위치는 ", index);
		selectedFiles.splice(index, 1);//배열에서 삭제 
	}
}