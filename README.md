



# practice_dewu

> 实战练手__类得物电商（部分功能尝试）



## 模块及服务实现

主要完成以下模块及其服务实现：

- ![img](images/yuque_diagram.svg)
- 通过懒加载查看商品列表：

<img src="images/image-20230925213302330.png" alt="image-20230925213302330" style="zoom: 33%;" />

- 点击查看商品详情：

<img src="images/image-20230925213328632.png" alt="image-20230925213328632" style="zoom:33%;" />

- 商品库存 > 1，进行下单操作：

<img src="images/image-20230925213340548.png" alt="image-20230925213340548" style="zoom:33%;" />

- 生成订单：

<img src="images/image-20230925231542828.png" alt="image-20230925231542828" style="zoom:33%;" />

- 接入支付接口，开始付款：

<img src="images/image-20230925214411116.png" alt="image-20230925214411116" style="zoom:33%;" />



## 技术方案

通过上述项目需求分析，可确定主要涉及以下技术方案：

1. 商品列表需要后端分页返回数据；
2. 商品支付时需要接入支付宝支付接口；
3. 购买成功时需要更新商品信息（库存及付款人数）
4. 使用redis解决并发问题



## 模型关系

分析操作流程：

​       由商品展示列点击进入商品详情页 ——> 选中商品付款 ——> 产生该用户购买商品的订单记录 ——> 调用支付宝支付接口



主要包括商品模块，用户模块，订单模块，支付模块，梳理各个模型之间的关系：

![img](images/pay_progress1-Page-3.svg)





## 商品SPU / 商品详情SKU 模型设计

- model层：

- ![img](images/associate.svg)
- 相应的数据库模型：

![img](images/dbdetail.svg)



- 导入product .sql、product_detail.sql 初始化测试数据
- 完成DAO以及对应的DAO.xml文件
- 设置前端向后端的自定义对象BasePageParam，处理分页的实现逻辑：

- ![img](images/pageprogress-169566401345033.svg)
- 设计商品服务接口及实现

- 完成api

## 用户模型设计



## 订单模型设计

<img src="images/image-20230925231822091.png" alt="image-20230925231822091" style="zoom:33%;" />

参考上图订单页面，订单模型设计主要包括：

1、存储主要信息（用户的信息、商品的信息等）

2、能够从订单信息看出该用户的购买情况

![img](images/ordertest-169566411590635.svg)



- 下单服务：

![image-20230925232900670](images/image-20230925232900670.png)

- 订单查询服务：

<img src="images/image-20230925233601013.png" alt="image-20230925233601013" style="zoom:33%;" />

![image-20230925233146037](images/image-20230925233146037.png)





## 支付模型设计



![img](images/alipayRequest01.svg)



![img](images/alipayResponse01.svg)



![img](images/payModel01.svg)



![img](images/payRecord01.svg)



![img](images/payModel01-16956632080626.svg)



![img](images/payRecord01-16956632173278-16956632173289.svg)



![img](images/payImg.svg)

![img](images/payApi.svg)

![img](images/payService01.svg)![img](images/orderService001.svg)



![img](images/payApi-169566337458214.svg)

![img](https://style.youkeda.com/img/ham/course/j15/notify_img.svg)







![img](images/payController.svg)





![img](images/payUrlController.svg)



![img](images/payCallBack.svg)



![img](images/callback05.svg)



![img](images/orderService02-169566366644421.svg)



![img](images/payCallBack-169566368088722.svg)



![img](images/updatePayRecord01.svg)



![img](images/payCallBack-169566376381725.svg)



![img](images/updatePersonNumber01.svg)



