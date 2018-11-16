<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form method="POST"
          action="/user/createuser" modelAttribute="user">
          <table>
              <tr>
                  <td><form:label path="username">username</form:label></td>
                  <td><form:input path="username"/></td>
              </tr>
              <tr>
                  <td><form:label path="password">password</form:label></td>
                  <td><form:input type="password" path="password"/></td>
              </tr>
              <tr>
                  <td><form:label path="firstname">
                    firstname</form:label></td>
                  <td><form:input path="firstname"/></td>
              </tr>
              <tr>
                    <td><form:label path="lastname">
                      lastname</form:label></td>
                    <td><form:input path="lastname"/></td>
                </tr>
              <tr>
                  <td><input type="submit" value="Submit"/></td>
              </tr>
          </table>
</form:form>