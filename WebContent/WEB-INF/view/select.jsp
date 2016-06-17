<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="kor">
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>순천향대학교 성적처리 시스템</title>

    <!-- 부트스트랩 CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- 사용자 CSS -->
    <link href="css/landing-page.css" rel="stylesheet">

    <!-- 사용자 Fonts -->
    <link href="font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="http://fonts.googleapis.com/css?family=Lato:300,400,700,300italic,400italic,700italic" rel="stylesheet" type="text/css">
</head>

<body>
    <!-- 네비게이션 바 -->
    <nav class="navbar navbar-default navbar-fixed-top topnav" role="navigation">
        <div class="container topnav">
            <!-- Nav 헤더 -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand topnav" href="index.jsp">순천향대 성적처리시스템</a>
            </div>
            <!-- 메뉴 목록 -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <a href="#about">About</a>
                    </li>
                    <li>
                        <a href="#services">성적 입력</a>
                    </li>
                    <li>
                        <a href="#contact">자유게시판</a>
                    </li>
                                                <u:isLogin>
                            <li>
							<!--  	CT: ${authUser.name}님, 안녕하세요. -->
								<a href="logout.do">로그 아웃</a>
							</li>
							<li>
								<a href="changePwd.do">암호 변경</a>
							</li>
							</u:isLogin>	
							<u:notLogin>
							<li>
								<a href="join.do">관리자등록</a>
							</li>
							<li>
								<a href="login.do">로그인하기</a>
							</li>
							</u:notLogin>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>


    <!-- Header -->
    <a name="about"></a>
    <div class="intro-header">
        <div class="container">

            <div class="row">
                <div class="col-lg-12">
                    <div class="intro-message">
                        <h1>순천향대학교 성적처리시스템</h1>
                        <h3>20124050 이건호</h3>
                        <hr class="intro-divider">
                        <ul class="list-inline intro-social-buttons">
                            <li>
                                <a href="https://twitter.com/SBootstrap" class="btn btn-default btn-lg"><i class="fa fa-twitter fa-fw"></i> <span class="network-name">Twitter</span></a>
                            </li>
                            <li>
                                <a href="https://github.com/djunhoo/JSP-Servlet_board" class="btn btn-default btn-lg"><i class="fa fa-github fa-fw"></i> <span class="network-name">Github</span></a>
                            </li>
                            <li>
                                <a href="#" class="btn btn-default btn-lg"><i class="fa fa-linkedin fa-fw"></i> <span class="network-name">Linkedin</span></a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>

        </div>
        <!-- /.container -->

    </div>
    <!-- /.intro-header -->

    <!-- Page Content -->

		<div class="form-group">
		  <form action="list.do" method="GET">
			  <label for="sel1">과목 선택 조회</label>
			  <select class="form-control" name="subject">
		 		<option value="영어">영어</option>
		 		<option value="수학">수학</option>
		 		<option value="과학">과학</option>
		 		<option value="국사">국사</option>
		 		<option value="전산">전산</option>
			  </select>
		  </form>
		</div>

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
