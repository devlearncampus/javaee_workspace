<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>AdminLTE 3 | Dashboard</title>
	<%@ include file="./inc/head_link.jsp" %>
</head>

<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper ml-5 mr-5 mt-5">
            <!-- Horizontal Form -->
            <div class="card card-info">
              <div class="card-header">
                <h3 class="card-title">Horizontal Form</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              
              <form class="form-horizontal">
                <div class="card-body">
                  <div class="form-group row">
                    <label for="inputEmail3" class="col-sm-2 col-form-label">ID</label>
                    <div class="col-sm-10">
                      <input type="email" class="form-control" id="id" placeholder="Your ID">
                    </div>
                  </div>
                  <div class="form-group row">
                    <label for="inputPassword3" class="col-sm-2 col-form-label">Password</label>
                    <div class="col-sm-10">
                      <input type="password" class="form-control" id="pwd" placeholder="Password">
                    </div>
                  </div>
                  <div class="form-group row">
                    <div class="offset-sm-2 col-sm-10">
                      <div class="form-check">
                        <input type="checkbox" class="form-check-input" id="exampleCheck2">
                        <label class="form-check-label" for="exampleCheck2">Remember me</label>
                      </div>
                    </div>
                  </div>
                </div>
                <!-- /.card-body -->
                <div class="card-footer">
                  <button type="button" class="btn btn-info" id="bt_login">Sign in</button>
                  
                </div>
                <!-- /.card-footer -->
              </form>
            </div>
</div>
<!-- ./wrapper -->
<!-- jQuery -->
<script src="/static/admin/plugins/jquery/jquery.min.js"></script>
<script type="text/javascript">
	function login(){
		let formData = $("form").serialize(); // id=zino&pwd=1111
		
		$.ajax({
			url : "/secure/admin/login", 
			type: "post", 
			data: formData,
			success:function(result, status, xhr){
				console.log(result, status, xhr);
			},
			error:function(xhr, status, err){
				console.log(xhr.responseText);
			}
		});
	}
	
	$(()=>{
		$("#bt_login").click(()=>{
			login()
		});
	});
</script>
</body>
</html>
