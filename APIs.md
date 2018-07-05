# 考验宝后端 API 文档

> baseUrl : https://kaoyan.letsgoduet.top/api
>
> 状态码表示请求成功与否

## User

- 注册

  path：/user

  method: **POST**

  params:  **formdata**

  | 字段  | 类型   | 说明   |
  | ----- | ------ | ------ |
  | uname | string | 用户名 |
  | pwd   | string | 密码   |
  | phone | string | 手机   |

  response: 无，返回 cookie 包含登陆信息



- 登陆

  path: /user/login

  method: **POST**

  params:

  | 字段  | 类型   | 说明 |
  | ----- | ------ | ---- |
  | uname | string |      |
  | pwd   | string |      |
  |       |        |      |

  response: 无，返回 cookie 包含登陆信息

- 用户详情

  path: /user/{id}

  method: **GET**

  params: 无

  response:

  ```json
  {
      "id":0,
      "uname":"uname",
      "phone":"phone"
  }
  ```

- 所有用户

  path: /user/all

  method: **GET**

  params: 无

  response:

  ```json
  [
     {
        "id":0,
        "uname":"uname",
        "phone":"phone"
    },
      ...
  ]
  ```



## Comm

- 创建（要登陆

  path: /comm

  method: **POST**
  params:

  | 字段    | 类型   | 说明 |
  | ------- | ------ | ---- |
  | title   | string | 标题 |
  | content | string | 内容 |
  |         |        |      |

  respons:

  ```json
  {
      "id":1,
      "title":"title",
      "content":"content",
      "create_t":150234234545,
      "update_t":150234234545,
      "pv":0,
      "u_id":1
  }
  ```

- 删除（要登陆

  path: /comm/{id}

  method: **DELETE**

  params: 无

  response: 无

- 更改（要登陆

  path: /comm/{id}

  method: **PUT**

  params:

  | 字段    | 类型   |      |
  | ------- | ------ | ---- |
  | title   | string |      |
  | content | string |      |
  |         |        |      |

  response: 无

- 详情

  path: /comm/{id}

  method: **GET**

  params: 无

  response:

  ```json
  {
      "id":1,
      "title":"title",
      "content":"content",
      "create_t":150234234545,
      "update_t":150234234545,
      "pv":123,
      "u_id":1
  }
  ```

- 全部

  path: /comm/all

  method: **GET**

  params: 无

  response:

  ```json
  [
      {
        "id":1,
        "title":"title",
        "content":"content",
        "create_t":150234234545,
        "update_t":150234234545,
        "pv":123,
        "u_id":1
    },
      ...
  ]
  ```



## 学校

- 获取详情，会增加 pv

  path: /school/{id}

  method: **GET**

  params: 无

  response:

  ```json
  {
  	"id":1,
      "name":"name",
      "intro":"intro",
      "site":"site",
      "district":"district",
      "cover":"cover",
      "logo":"logo",
      "pv":123
  }
  
  ```

- 获取所有

  path: /school/all

  method: **GET**

  params: 无

  response: 

  ```json
  [
      {
          "id":1,
          "name":"name",
          "intro":"intro",
          "site":"site",
          "district":"district",
          "cover":"cover",
          "logo":"logo",
          "pv":123
  	},
      ...
  ]
  ```

- 更新，只有管理员才有权限

  path: /school/{id}

  method: **PUT**

  params: 

  | 字段     | 类型   | 说明 |
  | -------- | ------ | ---- |
  | name     | string |      |
  | intro    | string |      |
  | district | string |      |
  | site     | string |      |
  | cover    | string |      |
  | logo     | string |      |

  



## 六大板块

> 剩下的内容只有请求 api 路径名不同，其余全部相同。下面以 grade 为例



- 获取

  path: /grade/{sid}，sid 表示学校id

  method: **GET**

  params: 无

  response：

  ```json
  [
      {
          "id":1,
          "title":"title",
          "content":"content",
          "s_id":1
      },
      ...
  ]
  ```

- 更新

  path: /grade/{sid}

  method: **PUT**

  params:

  | 字段    | 类型   | 说明 |
  | ------- | ------ | ---- |
  | title   | string |      |
  | content | string |      |
  |         |        |      |

  response: 无





> 其余 API 路径分别是
>
> /enrollreg/{sid}
>
> /grade/{sid}
>
> /major/{sid}
>
> /outline/{sid}
>
> /rate/{sid}
>
> /refbook/{sid}
>
>