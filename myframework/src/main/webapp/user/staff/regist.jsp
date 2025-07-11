<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script type="text/javascript">
	function regist(){
		$("form").attr({
			action:"/shop/staff/regist"
		});
	}
	
	$(()=>{
		$("button").click(()=>{
			regist();
		});
	});
</script>
</head>
<body>
		<form>		
			<pre>
				<input type="text" placeholder="이름" name="name">
				<input type="text" placeholder="급여 숫자로.." name="sal">
				<input type="text" placeholder="이메일" name="email">
				<br>
				<input type="text" placeholder="혈액형" name="blood">
				<input type="text" placeholder="키 cm" name="height">
				<input type="text" placeholder="몸무게 kg" name="weight">
				
				<button type="button">가입</button>
			</pre>
		</form>
	
</body>
</html>