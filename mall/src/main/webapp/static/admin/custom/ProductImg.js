/*이미지 썸네일 클래스 정의*/
class ProductImg{
	constructor(container, src, width, height ){
		this.container=container;
		this.src=src;
		this.width=width;
		this.height=height;
		this.wrapper = document.createElement("div");
		this.header = document.createElement("div");	 
		this.img=document.createElement("img");
		this.img.src=this.src;
		
		//style 
		this.img.style.width=this.width+"px";
		this.img.style.height=this.height+"px";
		
		this.wrapper.style.width=this.width+"px";
		this.wrapper.style.height=(this.height+20)+"px";
		this.wrapper.style.display="inline-block";
		this.wrapper.style.margin=2+"px";
			
		this.header.innerHTML="<a href='#'>X</a>";
		this.header.style.textAlign="right";
		
		//assemble 
		this.wrapper.appendChild(this.header);
		this.wrapper.appendChild(this.img);
		this.container.appendChild(this.wrapper);
		
	}	
	
}






