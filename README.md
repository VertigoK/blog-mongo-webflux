## **Simple CRUD App**
### **Reactive MongoDB / Spring WebFlux**


* Follow the steps below to run this app.
1. Download MongoDB Community Server (make sure to install MongoDB Compass as well):
   * https://www.mongodb.com/try/download/community
2. Download MongoDB Shell (mongosh):
   * https://www.mongodb.com/try/download/shell
3. Create a user and a password by running the following commands:
   * Run "mongosh" in powershell, cmd or terminal (for Windows)
   * Run "use admin"
   * Run "db.adminCommand(
        {
        createUser: "root",
        pwd: "12345",
        roles: [{role: "userAdminAnyDatabase", db: "admin"}, "readWriteAnyDatabase"]
        }
        )"
   * Run "show users" to check to see if the setup was done correctly

<p style="text-align:center;"><img src="https://res.cloudinary.com/practicaldev/image/fetch/s--ccinfBnG--/c_limit%2Cf_auto%2Cfl_progressive%2Cq_auto%2Cw_880/https://dev-to-uploads.s3.amazonaws.com/i/d46ng9w6g19okbl2jbmz.png"/></p>
