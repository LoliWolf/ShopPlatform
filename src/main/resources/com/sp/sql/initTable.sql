drop table if exists item_info;

drop table if exists item_type;

drop table if exists user_cart;

drop table if exists user_info;

drop table if exists user_order;

create table if not exists item_info
(
    pid int auto_increment comment '商品id',
    type_id int          null comment '商品类id',
    image     varchar(500) null comment '图片地址',
    pname    varchar(50)  null comment '名称',
    pdetails    varchar(200) null comment '介绍',
    price   float        null comment '价格',
    constraint item_info_pk
        primary key (pid)
)
    comment '商品信息表';


create table if not exists item_type
(
    type_id int         null comment '商品类id',
    type_name varchar(10) null comment '商品类名'
)
    comment '商品分类表';

create table if not exists user_info
(
    user_id  int auto_increment comment '用户id',
    account  varchar(20) null comment '账号',
    password varchar(20) null comment '密码',
    username     varchar(20) null comment '昵称',
    sex      varchar(3)  null comment '性别',
    mobile    varchar(20) null comment '手机号',
    address  varchar(50) null comment '收货地址',
    constraint user_info_pk
        primary key (user_id)
)
    comment '用户信息表';

create table if not exists user_cart
(
    user_id int null comment '用户id',
    pid int null comment '商品id',
    num int null comment '商品数量'
)
    comment '购物车';

create table if not exists user_order
(
    order_id varchar(20) null comment '订单号',
    status   bool        null comment '支付状态',
    user_id  int         null comment '用户id',
    pid  int         null comment '商品id',
    pnum int         null comment '商品数量',
    address varchar(50) null comment '送货地址'
)
    comment '用户订单表';


#用户数据样例
;
insert into user_info(account,password,username,sex,mobile,address) values ('1678768712@qq.com','123456','张三','男','12155143214','翻斗大街');
insert into user_info(account,password,username,sex,mobile,address) values ('476465455@qq.com','654321','李四','女','1234324123','翻斗二街');
insert into user_info(account,password,username,sex,mobile,address) values ('6576576587@qq.com','123321','王五','男','3124242214','成华大道');

#商品类样例
;
insert into item_type values (1,'手机电脑');
insert into item_type values (2,'家电');
insert into item_type values (3,'日用百货');

#商品样例
;
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1635332995.28485388.jpg',	'Redmi Note 11 Pro系列',	'三星AMOLED高刷屏 | JBL 对称式立体声 | 一亿像素超清影像 | 天玑920液冷芯 | VC液冷立体散热 |',	1599);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1640680211.34933571.png',	'Xiaomi 12X',	'骁龙870｜12bit 超视感屏｜黄金尺寸｜5000万疾速影像，3200万自拍｜对称立体声',	2699);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1635333557.04643739.jpg',	'Redmi Note 11 5G',	'双卡双5G | X轴线性马达 | 5000mAh 大电量 | 33W快充 | 立体声双扬声器 | 天玑810处理器 | 90Hz变速高刷屏',	1199 );
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1609158754.96998301.jpg',	'Xiaomi 11',	'骁龙888｜2K AMOLED 四曲面柔性屏｜1亿像素三摄｜时尚轻薄机身｜55W 有线闪充｜50W 无线闪充｜10W 无线反充｜LPDDR5｜WiFi6（增强版）｜视频「超级夜景」｜哈曼卡顿音频认证｜立体声双扬声器',	2699);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1595400896.08014623.jpg',	'Redmi 9A',	'6.53"超大护眼屏幕｜ 5000mAh长循环大电量｜ 大音量扬声器 ｜1300万AI相机 ｜人脸解锁｜G25八核处理器',	599);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1606288801.46329073.jpg',	'Redmi Note 9 系列',	'旗舰长续航｜128GB大存储起步',	1499 );
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1647430877.23348470.png',	'Redmi K50',	'天玑8100｜67W快充｜5500mAh大电池｜2K超清直屏｜像素加倍｜清晰加倍｜VC液冷散热｜OIS光学防抖｜杜比视界｜索尼4800万像素相机',	2399);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1653384563.45521577.png',	'Redmi Note 11T Pro系列',	'天玑8100｜144Hz高配LCD屏幕｜6400万像素｜VC液冷散热',	1699);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1648381367.21811717.jpg',	'Redmi 10A',	'6.53"大尺寸屏幕｜1300万超清主摄｜Helio G25八核处理器｜5000mAh充电宝级大电量｜观看轻松也清晰｜支持大字阅读｜聊天看书更省力',	649);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1569297737.97669352.jpg',	'Xiaomi MIX Alpha',	'创新环绕屏，极具未来感的智能交互体验 / 1亿像素超高清相机，超大感光元件 / 5G双卡全网通超高速网络 / 骁龙855Plus旗舰处理器 / 纳米硅基锂离子4050mAh电池，40W超级快充 / 钛合金+精密陶瓷+蓝宝石镜片前沿工艺',	19999);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1617014229.6133749.jpg',	'Xiaomi 11 青春版',	'轻薄、多彩 | 骁龙780G | 专业电影相机，前置超级夜景 | AMOLED 柔性直屏 | 超线性立体声双扬声器',	1769);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1653379001.74977175.png',	'Redmi Note 11SE',	'天玑700｜18W快充｜5000mAh大电池｜6.5"FHD+全高清屏｜双卡双5G｜90Hz 四挡变速高刷屏｜4096级 亮度调节｜全系128GB 大内存｜大功率扬声器｜4800万 高清双摄',	999);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1640679178.10917982.png',	'Xiaomi 12',	'全新一代 骁龙8 移动平台｜5000万超清主摄｜单手可握黄金手感｜6.28″超视感A+屏｜CyberFocus 万物追焦｜4500mAh大电量｜67W 有线秒充+50W无线秒充｜哈曼卡顿对称式立体声',	3699);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1615342330.97933727.jpg',	'Xiaomi 10S',	'骁龙870 | 对称式双扬立体声 | 1亿像素 8K电影相机 | 33W有线快充 | 30W无线快充 | 10W反向充电 | 4780mAh超大电池 | LPDDR5+UFS3.0+Wi-Fi 6 | VC液冷散热 | 双模5G',	2399);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1621955684.40846624.jpg',	'Redmi Note 10 5G',	'5G小金刚｜旗舰长续航｜双5G待机｜5000mAh充电宝级大容量｜4800万高清相机｜天玑700八核高性能处理器',	1099);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1647515841.88216147.png',	'Redmi K40S',	'骁龙870｜三星 E4直屏｜67W旗舰快充｜OIS光学防抖｜电竞级VC液冷｜4500mAh｜杜比全景声｜立体双扬声器｜潮流小立边',	1799);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1647431025.11693058.png',	'Redmi K50 Pro',	'天玑9000｜120W秒充｜5000mAh电池｜三星2K直屏｜VC液冷散热｜OIS光学防抖｜1亿像素',	2999);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1619422149.16423896.jpg',	'Redmi K40系列',	'骁龙870｜三星 E4直屏｜杜比全景声',	2399 );
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1656916095.71929521.png',	'Xiaomi 12S Ultra',	'徕卡专业光学镜头｜骁龙8+ 旗舰处理器｜徕卡原生双画质｜1 英寸大底专业主摄｜小米澎湃 P1 快充芯片｜全场景疾速抓拍｜IP68级防尘防水',	5999);
insert into item_info(type_id,image,pname,pdetails,price) values (1,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1634108516.94643643.png',	'Redmi Note 9 4G',	'6000mAh超长续航｜4800万超清三摄｜全高清6.53英寸护眼屏｜骁龙662处理器｜18W快速充电｜立体声双扬声器｜侧边指纹识别｜90%高屏占比｜康宁大猩猩保护玻璃',	899);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/02DC29B7F0BC1FCE4F6DA06274964124.png',	'米家智能蒸烤一体集成灶S1',	'磁吸旋钮|无把手自动开门设计|多场景智能保护|直喷式澎湃大蒸力',	8999);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1641884670.54047346.jpg',	'米家冰·洗烘套装 尊享版',	'大容量冰洗烘套装|莫兰迪高级灰家居配置|高效除菌除螨|一级能效低噪运行，安静省电不打扰',	7998);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1650424651.14634710.jpg',	'巨省电 新1级立式3匹（鎏金款）',	'舒适送风 格调出众 3匹变频 新一级能效',	5099);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1637737111.73936900.jpg',	'米家洗烘套装 10kg+10kg',	'专机专用/洗烘更专业/热泵烘干/低温柔烘更护衣/精准智能投放/洗涤更便捷/UVC紫外+银离子双重除菌/衣物更安全',	4898);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1648535805.16865141.png',	'米家全能扫拖机器人',	'自动洗拖布+自集尘| AI+3D避障|激光导航|全场景智能联动|热风烘干',	4599);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1640338954.90896911.jpg',	'小米即热净水器Q800',	'2.15L/min出水 | 3:1纯废水比 | 净水加热一体',	3999);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1652942451.59363313.jpg',	'米家智能变频升降吸油烟机S1烟灶套装4.5KW（天然气灶）',	'22m³/min|4500W|烟灶联动',	3699 );
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1626423331.13793765.jpg',	'小米双核净水器1200G',	'3.2L/min出水 | 5:1纯废水比 | 双RO过滤',	3499);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/E1B7B2CE5E7F40B264633285AF240F77.png',	'米家智能独嵌两用洗碗机15套S1',	'智能开合洗烘|4重立体喷洗|智能感应油污',	3499);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/904C0A72AB258E9D9DACEA913F15717D.png',	'米家智能嵌入式蒸烤一体机 S1',	'米家智能嵌入式蒸烤一体机 S1',	3499);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1541418170.92952541.jpg',	'米家新风机',	'300m³/h 大风量 / 换气富氧 / 净化抗霾 / 除醛去味 / 阻隔过敏源 / 智能控制',	2799);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1633949237.05256178.jpg',	'米家跨界烟灶套装S1 天然气',	'21m³/min|4500W|烟灶联动',	2598 );
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1648205046.85068606.jpg',	'米家台式净饮机 冷热版',	'冷热净三合一 | 5℃冰镇水 | 全隔断水箱',	2499);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1615691622.75895511.jpg',	'自然风 | 米家空调 1.5匹 新1级能效 鎏金版',	'舒适风感 | 智能清洁 | 智能互联',	2399 );
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1653226730.80575739.jpg',	'米家直驱洗烘一体机 10kg 简白版',	'直驱变频电机|智能洗烘一体|巴氏除菌高温除螨洗|微蒸空气洗|电机10年质保',	2199);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1574074258.80721325.jpg',	'米家空气净化器MAX 增强版',	'专业级除甲醛 | 澎湃净化力，适用84㎡大空间 | 高效净化PM2.5、过敏原和细菌',	2199 );
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/E91DFA8C94E765F911BDD81C66669045.png',	'米家无线洗地机',	'创新履带式滚刷|吸拖洗三合一|三面沿边清洁|毛发防缠绕',	2199);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1632908830.55364071.jpg',	'米家循环风空气净化器',	'8米送风 | 四季通用 | 智能环境管家',	2199);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1640229760.98653747.jpg',	'米家波轮洗衣机尊享版10kg',	'智能投放,洗衣液无残留/直驱电机,低噪洗涤/银离子除菌/1级能效/ 全屋智能互联',	1999);
insert into item_info(type_id,image,pname,pdetails,price) values (2,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1630321989.98829417.jpg',	'米家侧吸烟灶套装S1 天然气',	'20m³/min|4200W|烟灶联动',	1898 );
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/564A0690805904069BF204D442CE16AD.jpg',	'米家加湿器 2',	'99.9%银离子抗菌|300mL/h出雾量|轻音运行不扰眠|4L 水箱，保证加湿一整天',	99);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/10B7659CD6D71A3A78EEDB6DFC287D10.jpg',	'米家智能空气炸锅4L',	'健康无油炸 / 容量可变 / 智能云食谱 / 翻面提醒 / 长效控时，精准控温',	349);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/CEF286E0F6F2973EA0EE1F89AC6F5867.png',	'米家恒温电水壶2',	'智能屏显，实时显温 / 自来水，纯净水双煮水模式 / 4段保温模式 / 12h预约 / 1.5L大容量',	169 );
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj1.fds.api.mi-img.com/nr-pub/202206301521_1eccc2e0516643867a1c4415dcfb7061.png',	'米家便携式冲牙器',	'120mL便携式冲牙器，净力不输家用冲牙器，象牙白、樱花粉2色可选',	279 );
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/D8EE57C3B9F79262608F28E85543A73C.png',	'米家电磁炉青春版',	'2100W 功率 / 加粗密绕线圈 / 9 挡火力调节',	199 );
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/E6B56C33BA677E01CEEEBB29E025A45F.png',	'日常元素地面清洁剂',	'米家全能扫拖机器人专用',	99);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/BC4FA950EE851CF0794AE5138A0D4EFF.png',	'适配T200 米家声波电动牙刷头 3支装',	'抗菌护龈，高效清洁；弧面设计，更贴合牙齿',	39);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1653732043.76931698.jpg',	'个护清洁套装',	'乐享精致生活',	489 );
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/CBC6F20F91B8F41356390AAC8A72801B.png',	'米家电动剃须刀刀头S600',	'米家电动剃须刀刀头S600',	69);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/F4E692654CBA340BB80FEE00235B821C.png',	'米家电动剃须刀S600',	'小巧便携，强劲无刷电机',	349);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/71E56AA806D8BD7E4B48A9AAF95E6EA7.png',	'米家桌面移动风扇',	'桌面手持二合一|7羽扇叶出风|18.5小时超长续航|轻音送风',	129);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1649417580.05355221.jpg',	'米家智能直流变频循环扇 落地式',	'智能温湿度控风，超广域空气循环',	399);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1639284874.3145790.jpg',	'米家高速吹风机H700',	'超小机身/强劲风速/高清彩屏/智能温控',	549 );
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj1.fds.api.mi-img.com/mi-mall/3ab0b4bb24dd229dc53d3a554d71d866.jpg',	'小米定制心想甄选胶囊咖啡',	'精选原豆/密封保鲜/口味多样/欧洲直采',	158);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1588141296.4258865.jpg',	'米家手持挂烫机',	'熨衣不伤衣丨除菌除螨丨轻巧便携',	109);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1609403330.04142033.jpg',	'米家龙头净水器',	'高效超滤/4重强效过滤/透明视窗/3种出水方式/3步快装',	149);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1584692875.5955242.jpg',	'米家电动剃须刀S300',	'3D浮动贴面 / 双层刀片 / IPX7 级防水 / Type-C充电',	99);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1618995971.80912119.jpg',	'米家便携电热杯',	'350ml容量，可插拔式电源线设计 / 6小时长效保温 / 双层304不锈钢 / 防干烧保护 / 烧水倾倒保护 / 便携收纳包设计',	149 );
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1617286743.65585364.jpg',	'米家干衣机香芬块',	'清新茶香/花果浓香/固态精油香芬配方',	59);
insert into item_info(type_id,image,pname,pdetails,price) values (3,	'https://cdn.cnbj0.fds.api.mi-img.com/b2c-shopapi-pms/pms_1614755062.53172736.jpg',	'米家随行便携榨汁杯',	'单手可握，无线便携，果汁现榨鲜喝 / 一次榨汁只需35秒 / Type-C接口充电，满电至少可榨12杯 / 多重安全防护',	99);
