## User（用户 

| 字段名 | 类型   | 🌰              |
| ------ | ------ | -------------- |
| id     | int    | 0，自增        |
| uname  | string | kongdadiao     |
| phone  | stirng | 13018016800    |
| pwd    | string | 原密码+md5     |
| role   | int    | 0管理员，1群众 |



## School（学校 

| 字段名   | 类型   | 🌰                       |
| -------- | ------ | ----------------------- |
| id       | int    | 0                       |
| name     | string | 华中科技大学            |
| intro    | string | 渴🐔大学                 |
| district | string | 地区，华中、华北        |
| site     | string | https://www.hust.edu.cn |



## EnrolmentRegulation（招生简章 

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、3          |
| title   | string | 标题             |
| content | string | 正文             |
| sId    | int    | 学校id，external |





## Major（专业目录

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| sId    | int    | 学校id，external |



## ReferenceBook（参考书目

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| sId    | int    | 学校id，external |



## Grades（分数线 

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| sId    | int    | 学校id，external |



## Rate（报录比

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| sId    | int    | 学校id，external |



## Outline（考研大纲

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| sId    | int    | 学校id，external |



## Comm（交流 

| 字段名   | 类型   | 🌰                             |
| -------- | ------ | ----------------------------- |
| id       | int    |                               |
| title    | string |                               |
| content  | stirng |                               |
| u_id     | id     |                               |
| create_time | long   |                               |
| update_time | long   |                               |
| level    | int    | 0、1、2，管理员==0，群众1<->2 |

