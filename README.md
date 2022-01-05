## Workshop 11
1. ``` mvn spring-boot:run```
2. Press Ctrl + C to terminate spring boot process
3. heroku login
4. heroku create
5. git init
6. git remote -v if this returns you blank - > run step 6 else skip , move on to step 8
7. git remote add heroku ```<heroku git url>```
8. git branch -> return master or main
9. git add .
10. git commit -m "new"
11. Add a new file under the workshop 11 root directory -> append the below values into the system.properties file

```
java.runtime.version=17
```
12. git push heroku master/main
13. Copy the url and paste to the browser
14. Create a github repo
15. Execute the bellow command 
```
git remote add origin https://github.com/kenken64/javassf_workshop11.git
```
