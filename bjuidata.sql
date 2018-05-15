/*
SQLyog Ultimate v12.4.3 (64 bit)
MySQL - 5.0.18-nt : Database - bjuidata
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bjuidata` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bjuidata`;

/*Table structure for table `mainmenu` */

DROP TABLE IF EXISTS `mainmenu`;

CREATE TABLE `mainmenu` (
  `id` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `target` varchar(255) NOT NULL,
  `url` varchar(255) NOT NULL,
  `pid` int(11) NOT NULL,
  `zid` int(11) NOT NULL,
  `pname` varchar(255) NOT NULL,
  `zname` varchar(255) NOT NULL,
  KEY `zid` (`zid`),
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `mainmenu` */

insert  into `mainmenu`(`id`,`name`,`target`,`url`,`pid`,`zid`,`pname`,`zname`) values 
('q1','按钮','navtab','js/B-JUI.1.31/html/form/button.html',1,1,'表单相关','用户管理'),
('w1','文本框','navtab','js/B-JUI.1.31/html/form/input.html',1,1,'表单相关','用户管理'),
('s1','下拉选择框','navtab','js/B-JUI.1.31/html/form/select.html',1,1,'表单相关','用户管理'),
('s2','表单示例','navtab','js/B-JUI.1.31/html/form/form.html',2,1,'综合应用','用户管理'),
('d3','Navtab','navtab','js/B-JUI.1.31/html/base/navtab.html',1,2,'基础组件','权限管理'),
('f4','Dialog弹窗','navtab','js/B-JUI.1.31/html/base/dialog.html',1,2,'基础组件','权限管理'),
('g5','alertmsg消息窗口','navtab','js/B-JUI.1.31/html/base/alertmsg.html',1,2,'基础组件','权限管理'),
('h6','体检信息','navtab','js/B-JUI.1.31/html/datagrid/datagrid.html',3,1,'用户信息','用户管理'),
('h7','基本信息','navtab','jsp/user/userdatagrid.jsp',3,1,'用户信息','用户管理'),
('h8','收集整编','navtab','jsp/archives/sjzb.jsp',1,3,'档案管理','档案管理'),
('h9','档案检索','navtab','jsp/user/userdatagrid.jsp',1,3,'档案管理','档案管理');

/*Table structure for table `sjzbtree` */

DROP TABLE IF EXISTS `sjzbtree`;

CREATE TABLE `sjzbtree` (
  `id` int(11) NOT NULL,
  `pid` int(11) default NULL,
  `name` varchar(255) default NULL,
  `uri` varchar(255) default NULL,
  `target` varchar(255) default NULL,
  `isParent` varchar(255) default NULL,
  `hidden` varchar(255) default NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sjzbtree` */

insert  into `sjzbtree`(`id`,`pid`,`name`,`uri`,`target`,`isParent`,`hidden`) values 
(1,0,'紫光软件',NULL,NULL,'true',NULL),
(2,1,'科技档案',NULL,NULL,'true',NULL),
(3,1,'文书档案',NULL,NULL,'true',NULL),
(4,3,'文书1','jsp/archives/sjzbdatagrid.jsp','#layout01','false',NULL),
(5,2,'科技档案1','jsp/archives/sjzbdatagrid.jsp','#layout01','true',NULL),
(6,2,'科技档案2','jsp/archives/sjzbdatagrid.jsp','#layout01','true',NULL),
(13,1,'NewNode','jsp/archives/sjzbdatagrid.jsp','#layout01','false',NULL),
(14,2,'NewNode','jsp/archives/sjzbdatagrid.jsp','#layout01','true',NULL),
(15,5,'NewNode','jsp/archives/sjzbdatagrid.jsp','#layout01','false',NULL),
(20,6,'NewNode','jsp/archives/sjzbdatagrid.jsp','#layout01','false',NULL),
(21,14,'测试','jsp/archives/sjzbdatagrid.jsp','#layout01','false','username,age,birthday');

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `username` varchar(255) NOT NULL,
  `age` int(11) NOT NULL,
  `sex` varchar(10) NOT NULL,
  `birthday` date NOT NULL,
  `city` varchar(255) NOT NULL,
  `salary` double(10,2) NOT NULL,
  `starttime` date NOT NULL,
  `endtime` date NOT NULL,
  `description` varchar(255) NOT NULL,
  `permission` int(11) NOT NULL,
  KEY `id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user` */

insert  into `user`(`id`,`username`,`age`,`sex`,`birthday`,`city`,`salary`,`starttime`,`endtime`,`description`,`permission`) values 
(1,'小赵2',12,'2','2018-09-09','2',6500.55,'2018-03-22','2010-11-09','修改后的小赵',1),
(2,'小钱',20,'2','2018-01-10','3',49000.00,'2018-01-09','2018-01-17','我是小钱',2),
(3,'小孙',24,'2','2018-01-11','2',7000.00,'2018-01-10','2018-01-24','我是小孙',3),
(4,'小李',23,'1','2018-01-10','4',6500.00,'2018-01-02','2018-01-18','我是小李',3),
(5,'小周',26,'2','2018-01-11','3',7300.00,'2018-01-11','2018-01-24','我是小周',2),
(6,'小吴',24,'2','2018-01-10','2',5800.00,'2018-01-16','2018-01-25','我是小吴',1),
(7,'小郑',23,'1','2018-01-17','1',7400.00,'2018-01-17','2018-02-04','我是小郑',3),
(8,'小王',27,'1','2018-01-10','2',6700.00,'2018-01-23','2018-01-25','我是小王',3),
(9,'小舞',23,'2','2018-01-18','2',7000.00,'2018-01-17','2018-02-02','我是小舞',2),
(10,'赵晓斌',28,'1','2018-01-17','3',5000.00,'2018-01-17','2018-01-24','我是赵晓斌',1),
(11,'钱程',26,'1','2018-01-23','4',5300.00,'2018-01-25','2018-01-30','我是钱程',2),
(12,'孙福月',28,'2','2018-01-24','3',5200.00,'2018-01-23','2018-01-25','我是孙福月',2),
(13,'孙蕊',26,'2','2018-01-23','4',5600.00,'2018-01-23','2018-01-24','我是孙蕊',1),
(14,'李磊',29,'1','2018-01-16','2',5600.00,'2018-01-24','2018-01-23','我是李磊',2),
(15,'孟斌',30,'1','2018-01-23','1',5000.00,'2018-01-23','2018-01-23','我是孟斌 ',2),
(16,'李敏',26,'2','2018-01-30','2',7000.00,'2018-01-24','2018-02-03','我是李敏',1),
(17,'孟庆涛',27,'1','2018-01-23','3',5700.00,'2018-01-16','2018-01-18','我是孟庆涛',3),
(18,'周丽',26,'2','2018-01-16','2',6000.00,'2018-01-16','2018-01-12','我是周丽',1),
(19,'吴楠',27,'1','2018-01-19','3',5000.00,'2018-01-18','2018-01-25','我是吴楠',1),
(20,'郑龙晓',24,'1','2018-01-24','2',7000.00,'2018-01-18','2018-01-24','我是郑龙晓',2),
(21,'魏世兴',26,'1','2018-01-23','2',9000.00,'2018-01-17','2018-01-23','我是魏世兴',1),
(22,'王泽浩',27,'2','2018-01-30','1',8000.00,'2018-02-03','2018-02-23','我是王泽浩',2),
(23,'王斌',25,'2','2018-01-24','4',7800.00,'2018-01-23','2018-01-24','我是王斌',3),
(24,'刘斌',30,'2','2018-01-17','3',6000.00,'2018-01-16','2018-01-23','我是刘斌',2),
(25,'周婷',27,'1','2013-11-30','1',3300.50,'2018-09-10','2019-02-09','我是周婷',2),
(33,'啊啊',1,'2','2018-01-30','1',111.00,'2018-01-23','2018-01-23','111',1),
(34,'沙发1',1,'2','2018-01-23','1',11.00,'2018-01-23','2018-01-21','111',3),
(35,'小明',9,'1','2019-09-09','2',6.50,'2019-10-09','2019-09-09','0.0',3),
(36,'小芳',8,'2','2019-09-09','1',5.00,'2019-09-09','2019-09-09','9.0',2),
(37,'小明',9,'1','2019-09-09','2',6.50,'2019-10-09','2019-09-09','0.0',3),
(38,'小芳',8,'2','2019-09-09','1',5.00,'2019-09-09','2019-09-09','9.0',2),
(39,'赵淑芳',28,'1','2018-01-12','2',6500.00,'2017-12-09','2018-10-23','12.0',1),
(40,'小明',9,'1','2019-09-09','2',6.50,'2019-10-09','2019-09-09','0.0',1),
(41,'小芳',8,'2','2019-09-09','1',5.00,'2019-09-09','2019-09-09','9.0',2),
(42,'赵淑芳',28,'1','2018-01-12','2',6500.00,'2017-12-09','2018-10-23','12.0',2),
(43,'赵淑芳1',23,'2','2018-01-12','1',2222.00,'2017-12-09','2017-12-09','34.0',1),
(44,'3',9,'1','2019-09-09','2',6.50,'2019-10-09','2019-09-09','0.0',3),
(45,'小芳',8,'2','2019-09-09','1',5.00,'2019-09-09','2019-09-09','9.0',2),
(46,'1',28,'1','2018-01-12','2',6500.00,'2017-12-09','2018-10-23','12.0',1),
(47,'ROOT',22,'1','2018-01-17','3',8000.00,'2018-01-22','2018-02-03','23',2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
