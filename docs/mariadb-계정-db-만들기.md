
1. 모든 작업은 dba(root)로 한다.
```sh
# mysql -u root -p
```
2. 데이터베이스 생성
```sh
MariaDb [(none)]>create database webdb;
MariaDb [(none)]>show databases;
```

3. 사용자 생성
```sh
MariaDb [(none)]>create user 'webdb'@'localhost' idetified by 'webdb';
MariaDb [(none)]>create user 'myuser'@'192.168.%' idetified by 'myuser';
```

4. 권한주기
```sh
MariaDb [(none)]>grant all privileges on webdb.* to 'webdb'@'localhost';
MariaDb [(none)]>flush privileges;

MariaDb [(none)]>grant all privileges on myuser.* to 'myuser'@'192.168.%';
MariaDb [(none)]>flush privileges;
```

5. 확인하기
```sh
# mysql -u webdb -D webdb -p
password:
```

OPT_LOCAL_INFILE=1
