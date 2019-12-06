<h1>Java REST API Exam for ISR</h1>


<b>Get unique login dates:</b>
https://pure-chamber-49287.herokuapp.com/api/v1/test/dates<br><br><br>

<b>Get unique users:</b>
https://pure-chamber-49287.herokuapp.com/api/v1/test/users?start=YYYYMMDD&end=YYYYMMDD<br><br>
Sample:<br>
https://pure-chamber-49287.herokuapp.com/api/v1/test/users?start=20191201&end=20191210<br><br><br>

<b>Get unique logins:</b>
https://pure-chamber-49287.herokuapp.com/api/v1/test/logins?start=YYYYMMDD&end=YYYYMMDD&user=value&firstName=value&middleName=value&lastName=value&emailAddress=value<br><br>
Sample:<br>
https://pure-chamber-49287.herokuapp.com/api/v1/test/logins?start=20191201&end=20191210&user=value&firstName=value&middleName=value&lastName=value&emailAddress=value<br><br><br>

<b>Create new logins:</b>
https://pure-chamber-49287.herokuapp.com/api/v1/test/data/createLogins?count=INTEGER&loginDate=DATE<br><br>
Sample:<br>
https://pure-chamber-49287.herokuapp.com/api/v1/test/data/createLogins?count=50&loginDate=20191205
