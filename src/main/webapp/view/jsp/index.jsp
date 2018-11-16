<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>

    <style>
        td, tr, th {
        border: solid 1px black;
        }
    </style>

<meta name="_csrf" content="${_csrf.token}"/>
    <!-- default header name is X-CSRF-TOKEN -->
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
</head>
User Logged In: ${user}
<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>
<form method="POST" enctype="multipart/form-data" action="/upload">
			<table>
				<tr><td>File to upload:</td><td><input type="file" name="files" multiple/></td></tr>
				<tr><td></td><td><input type="submit" value="Upload" /></td></tr>
			</table>
			<input type="hidden"
                name="${_csrf.parameterName}"
                value="${_csrf.token}"/>
		</form>
		<h2>My Songs</h2>
        <table>
            <tr>
                <th>Artist</th>
                <th>Song</th>
                <th>Album</th>
                <th>Genre</th>
                <th>Uploader</th>
                <th></th>
            </tr>
            <c:forEach items="${trackInfoList}" var="trackInfo">
                <tr>
                    <td><c:forEach items="${trackInfo.artists}" var="artist">${artist}</c:forEach></td>
                    <td>${trackInfo.song}</td>
                    <td>${trackInfo.album}</td>
                    <td>${trackInfo.genre}</td>
                    <td>${user}</td>
                    <td><a style="text-decoration:none;" href="/download/${trackInfo.trackFile.name}">Download</a></td>
                </tr>
            </c:forEach>
        <table>
        <br>
        <br>
        <h2>Other Songs</h2>
        <table>
                    <tr>
                        <th>Artist</th>
                        <th>Song</th>
                        <th>Album</th>
                        <th>Genre</th>
                        <th>Uploader</th>
                        <th></th>
                    </tr>
                    <c:forEach items="${globalTrackInfoList}" var="globalTrackInfo">
                        <tr>
                            <td><c:forEach items="${globalTrackInfo.artists}" var="artist">${artist}</c:forEach></td>
                            <td>${globalTrackInfo.song}</td>
                            <td>${globalTrackInfo.album}</td>
                            <td>${globalTrackInfo.genre}</td>
                            <td>${globalTrackInfo.uploader}</td>
                            <td><a style="text-decoration:none;" href="/download/${trackInfo.trackFile.name}">Download</a></td>
                        </tr>
                    </c:forEach>
                <table>