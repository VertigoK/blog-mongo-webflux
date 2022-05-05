## **Simple CRUD App**
### **Reactive MongoDB / Spring WebFlux**

1. Download MongoDB Community Server (make sure to install MongoDB Compass as well):
   https://www.mongodb.com/try/download/community
2. Download MongoDB Shell (mongosh):
   https://www.mongodb.com/try/download/shell
3. Create a user and a password by running the following commands:
   * Run "mongosh" in powershell, cmd or terminal (for Windows) then "test> " will show up.
   * Run "use admin" then "switched to db admin" and "admin> " will show up.
   * Run "db.adminCommand(
        ... {
        ..... createUser: "root",
        ..... pwd: "12345",
        ..... roles: [{role: "userAdminAnyDatabase", db: "admin"}, "readWriteAnyDatabase"]
        ..... }
        ... )" then it will set up a new user and a password.
   * Run "show users" then the information of the user you just created will show up.

<img src="https://res.cloudinary.com/practicaldev/image/fetch/s--ccinfBnG--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_880/https://dev-to-uploads.s3.amazonaws.com/i/d46ng9w6g19okbl2jbmz.png"/>
