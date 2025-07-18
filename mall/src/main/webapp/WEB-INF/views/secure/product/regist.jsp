<%@page import="mall.domain.TopCategory"%>
<%@page import="java.util.List"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	List<TopCategory> topList=(List)request.getAttribute("topList");
%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>AdminLTE 3 | Dashboard</title>
	
	<%@ include file="../inc/head_link.jsp" %>

</head>
<body class="hold-transition sidebar-mini layout-fixed">
<div class="wrapper">

  <!-- Preloader -->
  <div class="preloader flex-column justify-content-center align-items-center">
    <img class="animation__shake" src="/static/admin/dist/img/AdminLTELogo.png" alt="AdminLTELogo" height="60" width="60">
  </div>

  <!-- Navbar -->
	<%@ include file="../inc/navbar.jsp" %>
  <!-- /.navbar -->

  <!-- Main Sidebar Container -->
	<%@ include file="../inc/left_bar.jsp" %>

  <!-- Content Wrapper. Contains page content -->
  <div class="content-wrapper">
    
    <!-- Content Header (Page header) -->
    <div class="content-header">
      <div class="container-fluid">
        <div class="row mb-2">
          <div class="col-sm-6">
            <h1 class="m-0">상품 등록</h1>
          </div><!-- /.col -->
          <div class="col-sm-6">
            <ol class="breadcrumb float-sm-right">
              <li class="breadcrumb-item"><a href="#">Home</a></li>
              <li class="breadcrumb-item active">상품관리>상품등록</li>
            </ol>
          </div><!-- /.col -->
        </div><!-- /.row -->
      </div><!-- /.container-fluid -->
    </div>
    <!-- /.content-header -->


    <!-- Main content -->
    <section class="content">
      <div class="container-fluid">
      
            <!-- 상품 등록 폼 시작 -->
            <div class="card card-primary">
              <div class="card-header">
                <h3 class="card-title">상품 등록 폼</h3>
              </div>
              <!-- /.card-header -->
              <!-- form start -->
              <form>
                <div class="card-body">
                	<!-- 카테고리 영역 시작 -->
	                  <div class="row">
	                    <div class="col-sm-6">
	                      <!-- Select multiple-->
	                      <div class="form-group">
	                        <label>상위 카테고리</label>
	                        <select class="form-control">
	                        
	                          <option value="0">카테고리 선택</option>
	                          
	                          <%for(TopCategory topcategory  : topList){ %>
	                          <option value="<%=topcategory.getTopcategory_id() %>"><%=topcategory.getTop_name() %></option>
	                          <%} %>

	                        </select>
	                      </div>
	                    </div>
	                    <div class="col-sm-6">
	                      <div class="form-group">
	                        <label>하위 카테고리</label>
	                        <select class="form-control">
	                          <option>option 1</option>
	                          <option>option 2</option>
	                          <option>option 3</option>
	                          <option>option 4</option>
	                          <option>option 5</option>
	                        </select>
	                      </div>
	                    </div>
	                  </div>
                	<!-- 카테고리 영역 끝 -->
                  <div class="form-group">
                    <input type="text" class="form-control" name="product_name" placeholder="상품명 입력">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="product_name" placeholder="브랜드 입력">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="product_name" placeholder="가격 입력">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="product_name" placeholder="할인가 입력">
                  </div>
                  <div class="form-group">
                    <input type="text" class="form-control" name="product_name" placeholder="간단소개 100자 이하 ">
                  </div>
				   <div class="form-group">
                       <select class="form-control">
                         <option>색상 선택</option>
                       </select>
	              </div>
				  
				  <div class="form-group">
                       <select class="form-control">
                         <option>사이즈 선택</option>
                       </select>
	              </div>
	              
                  <div class="form-group">
                    <input type="text" class="form-control" name="product_name" placeholder="상품명 입력">
                  </div>
                  
                  <div class="form-group">
                  
		<!-- 편집 시작 -->
		<div class="row">
		  <div class="col-md-12">
		    <div class="card card-outline card-info">
		      <div class="card-header">
		        <h3 class="card-title">
		          CodeMirror
		        </h3>
		      </div>
		      <!-- /.card-header -->
		            <div class="card-body p-0">
		              <textarea id="codeMirrorDemo" class="p-3">
		<div class="info-box bg-gradient-info">
		  <span class="info-box-icon"><i class="far fa-bookmark"></i></span>
		  <div class="info-box-content">
		    <span class="info-box-text">Bookmarks</span>
		    <span class="info-box-number">41,410</span>
		    <div class="progress">
		      <div class="progress-bar" style="width: 70%"></div>
		    </div>
		    <span class="progress-description">
		      70% Increase in 30 Days
		    </span>
		  </div>
		</div>
		              </textarea>
		            </div>
		            <div class="card-footer">
		              Visit <a href="https://codemirror.net/">CodeMirror</a> documentation for more examples and information about the plugin.
		            </div>
		          </div>
		        </div>
		        <!-- /.col-->
		</div>
		<!-- 편집기 끝-->
                  
                  </div>
                  <div class="form-group">
                    <div class="input-group">
                      <div class="custom-file">
                        <input type="file" class="custom-file-input" id="exampleInputFile">
                        <label class="custom-file-label" for="exampleInputFile">상품 이미지 선택</label>
                      </div>
                      <div class="input-group-append">
                        <span class="input-group-text">Upload</span>
                      </div>
                    </div>
                  </div>
                  <div class="form-check">
                    <input type="checkbox" class="form-check-input" id="exampleCheck1">
                    <label class="form-check-label" for="exampleCheck1">Check me out</label>
                  </div>
                </div>
                <!-- /.card-body -->

                <div class="card-footer">
                  <button type="submit" class="btn btn-primary">Submit</button>
                </div>
              </form>
            </div>
            <!-- 상품 등록 폼 끝-->
        
      </div>
      <!-- /.container-fluid -->
    </section>
    <!-- /.content -->
  </div>
  <!-- /.content-wrapper -->
	<%@ include file="../inc/footer.jsp" %>

  <!-- Control Sidebar -->
	<%//@ include file="../inc/right_bar.jsp" %>
  <!-- /.control-sidebar -->
</div>
<!-- ./wrapper -->
	<%@ include file="../inc/footer_link.jsp" %>

	<!-- Summernote -->
	<script src="/static/admin/plugins/summernote/summernote-bs4.min.js"></script>
	
	<!-- CodeMirror -->
	<script src="/static/admin/plugins/codemirror/codemirror.js"></script>
	<script src="/static/admin/plugins/codemirror/mode/css/css.js"></script>
	<script src="/static/admin/plugins/codemirror/mode/xml/xml.js"></script>
	<script src="/static/admin/plugins/codemirror/mode/htmlmixed/htmlmixed.js"></script>
	
	<script>
	  $(function () {
	    // Summernote
	    $('#summernote').summernote()
	
	    // CodeMirror
	    CodeMirror.fromTextArea(document.getElementById("codeMirrorDemo"), {
	      mode: "htmlmixed",
	      theme: "monokai"
	    });
	  })
	</script>
	
</body>
</html>














