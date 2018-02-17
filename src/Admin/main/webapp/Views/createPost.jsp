<!DOCTYPE html>
<html>
<head>
    <title>Create new Post</title>
    <link rel = "stylesheet" href = "style.css" type = "text/css"> </link>
</head>
<body>
<div>
    <fieldset><legend class="legend">Create New Product</legend>
        <form action = "dataVerifier" method = "post">
            <table>
                <tbody>
                <tr style = "background: white;}">
                    <td><label for = "postLocation">Post Location:</label></td><td>
                    <input id = "postLocation" name = "postLocation" type = "text"
                           minlength = "8" required/></td>
                </tr>
                <tr style = "background: white;}">
                    <td><label for = "postCategory"> Post Category:</label></td><td>
                    <input id = "postCategory" name = "postCategory" type = "text"
                           minlength ="8" required/></td>
                </tr>
                <tr style = "background: white;}">
                    <td><label for = "postViews">Post Views:</label></td><td>
                    <input id = "postViews" name = "postViews" type = "number" required/></td>
                </tr>
                </tbody>
            </table>
            <p><input type="submit" value=" Create Post "/></p>
        </form>
        <p><a href = "${pageContext.request.contextPath}ctidStuff.jsp">Back</a></p>
    </fieldset>
</div>
</body>
</html>
