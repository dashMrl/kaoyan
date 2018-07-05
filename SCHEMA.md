## user（用户

| 字段名 | 类型   | 🌰              |
| ------ | ------ | -------------- |
| id     | long    | 0，自增        |
| uname  | string | kongdadiao     |
| phone  | stirng | 13018016800    |
| pwd    | string | 原密码+md5     |
| role   | int    | 0管理员，1群众 |



## school（学校

| 字段名   | 类型   | 🌰                       |
| -------- | ------ | ----------------------- |
| id       | long    | 0                       |
| name     | string | 华中科技大学            |
| intro    | string | 渴🐔大学                 |
| district | string | 地区，华中、华北        |
| site     | string | https://www.hust.edu.cn |
| cover    | string | https://www.hust.edu.cn |
| logo     | string | https://www.hust.edu.cn |
| pv       | long   |                                |



## enrolment_regulation（招生简章

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | long    | 0、1、3          |
| title   | string | 标题             |
| content | string | 正文             |
| s_id    | int    | 学校id，external |





## major（专业目录

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | long    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| s_id    | long    | 学校id，external |



## reference_book（参考书目

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | long    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| s_id    | long    | 学校id，external |



## grade（分数线

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| s_id    | long    | 学校id，external |



## rate（报录比

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| s_id    | long    | 学校id，external |



## outline（考研大纲

| 字段名  | 类型   | 🌰                |
| ------- | ------ | ---------------- |
| id      | int    | 0、1、2          |
| title   | string | 标题             |
| content | string | 正文             |
| s_id    | long    | 学校id，external |



## comm（交流

| 字段名   | 类型   | 🌰                             |
| -------- | ------ | ----------------------------- |
| id       | long    |                               |
| title    | string |                               |
| content  | stirng |                               |
| u_id     | long     |                               |
| create_time | long   |                               |
| update_time | long   |                               |
| level    | int    | 0、1、2，管理员==0，群众1<->2 |
| pv    | long    |                                |

