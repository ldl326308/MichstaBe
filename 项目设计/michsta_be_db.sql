-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.5.0-MariaDB - mariadb.org binary distribution
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for michsta_be_db
DROP DATABASE IF EXISTS `michsta_be_db`;
CREATE DATABASE IF NOT EXISTS `michsta_be_db` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `michsta_be_db`;

-- Dumping structure for table michsta_be_db.article
DROP TABLE IF EXISTS `article`;
CREATE TABLE IF NOT EXISTS `article` (
  `article_id` varchar(200) NOT NULL COMMENT '文章ID',
  `article_alias` varchar(20) NOT NULL COMMENT '文章别名',
  `article_title` varchar(300) NOT NULL COMMENT '标题',
  `article_img` varchar(300) DEFAULT '' COMMENT '展示图',
  `article_basic` varchar(300) NOT NULL COMMENT '文章简介',
  `article_html_content` longtext NOT NULL COMMENT '文章html',
  `article_markdown_content` longtext NOT NULL DEFAULT '' COMMENT '文章markdow',
  `article_create_date` varchar(20) NOT NULL COMMENT '文章发布日期',
  `article_last_update_date` varchar(20) NOT NULL COMMENT '文章最后修改时间',
  `article_protect` varchar(100) NOT NULL COMMENT '密码保护',
  `article_stick` int(11) DEFAULT 0 COMMENT '文章置顶',
  `article_state` int(11) DEFAULT 0 COMMENT '文章状态',
  `article_like_count` int(11) DEFAULT 0 COMMENT '文章点赞数',
  `article_sick_of_count` int(11) DEFAULT 0 COMMENT '文章讨厌数',
  PRIMARY KEY (`article_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table michsta_be_db.article: ~13 rows (大约)
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` (`article_id`, `article_alias`, `article_title`, `article_img`, `article_basic`, `article_html_content`, `article_markdown_content`, `article_create_date`, `article_last_update_date`, `article_protect`, `article_stick`, `article_state`, `article_like_count`, `article_sick_of_count`) VALUES
	('04be9e4c-b891-477a-87c7-ebe728c865dc', '286.html', '嘻嘻嘻嘻嘻爱', '', '嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻\n可可可可可可可可可可\n绝望\n窗前明月光', '<p>嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻</p>\n<h6><a id="_1"></a>可可可可可可可可可可</h6>\n<h5><a id="_2"></a>绝望</h5>\n<p>窗前明月光</p>\n', '嘻嘻嘻嘻嘻嘻嘻嘻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻寻\n###### 可可可可可可可可可可\n##### 绝望\n窗前明月光', '2020-08-18', '2020-08-18 21:41:23', '22', 0, 0, 0, 0),
	('0f7f9d32-1d13-41ed-b81b-eef254b3a729', '1977.html', 'love Love LoVe', '', 'lover lover lover\nlover lover\nLover\nLover\nGet LLLLL\nGKKKKKKSKSK\nOJBK', '<p>lover lover lover</p>\n<h4><a id="lover_lover_1"></a>lover lover</h4>\n<h1><a id="Lover_2"></a>Lover</h1>\n<h2><a id="Lover_3"></a>Lover</h2>\n<p>Get LLLLL<br />\nGKKKKKKSKSK<br />\nOJBK</p>\n', 'lover lover lover\n#### lover lover \n# Lover \n## Lover\n\nGet LLLLL\nGKKKKKKSKSK\nOJBK', '2020-08-18', '2020-08-18 21:45:41', '', 0, 0, 0, 0),
	('1669ae1e-0917-46cb-bbfa-fe5c02b7af5f', '2352.html', 'where where where', '', 'where you are?', '<h4><a id="where_you_are_0"></a>where you are?</h4>\n', '#### where you are?', '2020-08-18', '2020-08-18 21:43:18', '', 0, 0, 0, 0),
	('2139f134-ba0a-4adf-be58-3f30cc1856e8', '184.html', '发布测试博客', '', '我测试我测试我测试我测试\n我测试我测试\n我测试\n我测试\n我测试\n我测试\n我测试\n我测试\n我测试我测试\n我测试我测试我测试我测试我测试我测试我测试我测试我测试我测', '<p>我测试我测试我测试我测试<br />\n我测试我测试</p>\n<p>我测试<br />\n我测试<br />\n我测试<br />\n我测试<br />\n我测试<br />\n我测试<br />\n我测试我测试<br />\n我测试我测试我测试我测试我测试我测试我测试我测试我测试我测试</p>\n', '我测试我测试我测试我测试\n我测试我测试\n\n我测试\n我测试\n我测试\n我测试\n我测试\n我测试\n我测试我测试\n我测试我测试我测试我测试我测试我测试我测试我测试我测试我测试', '2020-08-18', '2020-08-18 21:46:06', '', 0, 0, 0, 0),
	('23d9cf51-ad5b-42c8-b5b7-b7486edf0e47', '1121.html', '随机', '', 'fffffffffff发发发\n辛苦辛苦辛苦先看看\n凸凸凸凸凸凸凸凸凸凸凸\n热闹热闹热闹热闹热闹热闹能容纳你', '<p>fffffffffff发发发<br />\n辛苦辛苦辛苦先看看</p>\n<h3><a id="_2"></a>凸凸凸凸凸凸凸凸凸凸凸</h3>\n<p>热闹热闹热闹热闹热闹热闹能容纳你</p>\n', 'fffffffffff发发发\n辛苦辛苦辛苦先看看\n### 凸凸凸凸凸凸凸凸凸凸凸\n热闹热闹热闹热闹热闹热闹能容纳你', '2020-08-18', '2020-08-18 21:41:48', '', 0, 0, 0, 0),
	('325f3613-abed-4233-82a0-5e531938c360', '2616.html', '波波波波可', '', '反反复复付付付付付付付付付付付付付付\n付付付付付付付付付付付付付付付付付付付付付付付\n岁月不用回头\n你也不用爱我', '<p>反反复复付付付付付付付付付付付付付付<br />\n付付付付付付付付付付付付付付付付付付付付付付付</p>\n<h4><a id="_2"></a>岁月不用回头</h4>\n<h5><a id="_3"></a>你也不用爱我</h5>\n', '反反复复付付付付付付付付付付付付付付\n付付付付付付付付付付付付付付付付付付付付付付付\n#### 岁月不用回头\n##### 你也不用爱我', '2020-08-18', '2020-08-18 21:40:35', '', 0, 0, 0, 0),
	('44a4e755-23b3-49b8-a633-6e23e538d809', '443.html', '我我我我我我吐了吐了', '', '系我嘻嘻嘻嘻嘻嘻\nfile file file fee feee GGGEEETTT', '<p>系我嘻嘻嘻嘻嘻嘻</p>\n<h3><a id="file_file_file_fee_feee_GGGEEETTT_2"></a>file file file fee feee GGGEEETTT</h3>\n', '系我嘻嘻嘻嘻嘻嘻 \n\n### file file file fee feee GGGEEETTT', '2020-08-18', '2020-08-18 21:42:43', '', 0, 0, 0, 0),
	('573c9ff1-ee35-4b27-aee7-f3381206b811', '1736.html', '我疯狂测试啊啊', '', '啊啊啊啊啊啊啊啊啊\n我疯狂测试啊啊\n我疯狂测试啊啊\n少时诵诗书所所所所所所所\n我疯狂测试啊啊', '<p>啊啊啊啊啊啊啊啊啊<br />\n我疯狂测试啊啊</p>\n<p>我疯狂测试啊啊</p>\n<p>少时诵诗书所所所所所所所</p>\n<p>我疯狂测试啊啊</p>\n', '啊啊啊啊啊啊啊啊啊\n我疯狂测试啊啊\n\n我疯狂测试啊啊\n\n\n少时诵诗书所所所所所所所\n\n我疯狂测试啊啊', '2020-08-18', '2020-08-18 21:46:22', '', 0, 0, 0, 0),
	('6017048d-8bc1-4ad5-9631-791c7a048fcb', '902.html', '谁的青春结束了', '', '五级标题\n标记\n\n段落引用', '<h5><a id="_0"></a>五级标题</h5>\n<p><mark>标记</mark></p>\n<blockquote>\n<p>段落引用</p>\n</blockquote>\n', '##### 五级标题\n\n\n==标记==\n\n> 段落引用', '2020-08-18', '2020-08-18 21:44:27', '', 0, 0, 0, 0),
	('b848d3ad-e152-473d-b03f-624b80551289', '1123.html', 'filie file file', '', '赵丽颖\n结婚了\n孩子都两岁了\n眼睛没有光了', '<h4><a id="_0"></a>赵丽颖</h4>\n<h5><a id="_1"></a>结婚了</h5>\n<p>孩子都两岁了<br />\n眼睛没有光了</p>\n', '#### 赵丽颖\n##### 结婚了\n孩子都两岁了\n眼睛没有光了', '2020-08-18', '2020-08-18 21:44:06', '', 0, 0, 0, 0),
	('b9ac4502-b533-4011-94ab-39c31f990761', '725.html', '究极测试', '', 'public static void main(String[] args)\n{\n   System.out.println("Hello,World!");', '<pre><div class="hljs"><code class="lang-java"><span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> <span class="hljs-keyword">void</span> <span class="hljs-title">main</span><span class="hljs-params">(String[] args)</span>\n</span>{\n   System.out.println(<span class="hljs-string">"Hello,World!"</span>);\n}\n\n</code></div></pre>\n<h4><a id="Java_8"></a>Java天下第一</h4>\n', '```java\npublic static void main(String[] args)\n{\n   System.out.println("Hello,World!");\n}\n\n```\n\n#### Java天下第一\n', '2020-08-18', '2020-08-18 22:08:53', '', 0, 0, 0, 0),
	('e12c3e91-909b-4f48-a6b8-72dccf98ac0c', '2814.html', '听歌啊啊啊', '', '最好听得歌嘻嘻嘻嘻\n哈哈哈哈哈哈', '<p>最好听得歌嘻嘻嘻嘻<br />\n哈哈哈哈哈哈</p>\n', '最好听得歌嘻嘻嘻嘻\n哈哈哈哈哈哈', '2020-08-18', '2020-08-18 21:42:13', '', 0, 0, 0, 0),
	('ec59708e-87b3-4e56-9851-fb23211dd00b', '1133.html', '炼狱', '', '等一下打一把王者？\n真的吗？假的吧？', '<p>等一下打一把王者？<br />\n真的吗？假的吧？</p>\n', '等一下打一把王者？\n真的吗？假的吧？', '2020-08-18', '2020-08-18 21:44:47', '', 0, 0, 0, 0);
/*!40000 ALTER TABLE `article` ENABLE KEYS */;

-- Dumping structure for table michsta_be_db.causerie
DROP TABLE IF EXISTS `causerie`;
CREATE TABLE IF NOT EXISTS `causerie` (
  `causerie_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '随笔ID',
  `causerie_alias` varchar(20) NOT NULL COMMENT '随笔别名',
  `causerie_title` varchar(100) NOT NULL COMMENT '随笔标题',
  `causerie_basic` varchar(300) NOT NULL COMMENT '随笔简介',
  `causerie_markdown_content` longtext NOT NULL COMMENT '随笔markdown',
  `causerie_html_content` longtext NOT NULL COMMENT '随笔html',
  `causerie_create_time` varchar(20) NOT NULL COMMENT '发布时间',
  `causerie_state` int(11) DEFAULT 0 COMMENT '随笔状态',
  PRIMARY KEY (`causerie_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- Dumping data for table michsta_be_db.causerie: ~6 rows (大约)
/*!40000 ALTER TABLE `causerie` DISABLE KEYS */;
INSERT INTO `causerie` (`causerie_id`, `causerie_alias`, `causerie_title`, `causerie_basic`, `causerie_markdown_content`, `causerie_html_content`, `causerie_create_time`, `causerie_state`) VALUES
	(2, '2238.html', '第一条随笔', '哈哈哈哈哈哈哈哈\n嘻嘻嘻嘻嘻嘻爱\n咔咔咔咔咔咔扩扩\n如果爱可以重来\n', '哈哈哈哈哈哈哈哈\n嘻嘻嘻嘻嘻嘻爱\n咔咔咔咔咔咔扩扩\n#### 如果爱可以重来', '<p>哈哈哈哈哈哈哈哈<br />\n嘻嘻嘻嘻嘻嘻爱<br />\n咔咔咔咔咔咔扩扩</p>\n<h4><a id="_3"></a>如果爱可以重来</h4>\n', '2020-08-18 21:30:20', 0),
	(3, '1554.html', '第二条随笔', '那一次我看着你，消失在人海\n//如果爱可以重来\npublic static void main(String[] args)\n{\n   System.out.println("告辞");\n}\n\n\n', '##### 那一次我看着你，消失在人海\n\n```java\n//如果爱可以重来\npublic static void main(String[] args)\n{\n   System.out.println("告辞");\n}\n\n```\n', '<h5><a id="_0"></a>那一次我看着你，消失在人海</h5>\n<pre><div class="hljs"><code class="lang-java"><span class="hljs-comment">//如果爱可以重来</span>\n<span class="hljs-function"><span class="hljs-keyword">public</span> <span class="hljs-keyword">static</span> <span class="hljs-keyword">void</span> <span class="hljs-title">main</span><span class="hljs-params">(String[] args)</span>\n</span>{\n   System.out.println(<span class="hljs-string">"告辞"</span>);\n}\n\n</code></div></pre>\n', '2020-08-18 21:31:34', 0),
	(4, '702.html', '他们最幸福', '星光不问赶路人，\n时光不负有心人。\n心中的伤痛又有谁能够明白，\n如果爱可以重来。\n我绝地不会放开\n因为我一明白…\n', '星光不问赶路人，\n时光不负有心人。\n\n心中的伤痛又有谁能够明白，\n如果爱可以重来。\n我绝地不会放开\n因为我一明白...', '<p>星光不问赶路人，<br />\n时光不负有心人。</p>\n<p>心中的伤痛又有谁能够明白，<br />\n如果爱可以重来。<br />\n我绝地不会放开<br />\n因为我一明白…</p>\n', '2020-08-18 21:32:37', 0),
	(5, '959.html', '第四条随笔', '好恨我自己没有把你留下来\n', '好恨我自己没有把你留下来', '<p>好恨我自己没有把你留下来</p>\n', '2020-08-18 21:33:01', 0),
	(6, '22.html', '55555555', '5555555555\n', '5555555555', '<p>5555555555</p>\n', '2020-08-18 21:33:42', 0),
	(7, '1117.html', '你存在', '我深深的脑海了\n世界之大，为何我们相遇。\n你存在\n我深深的脑海了\n我的梦里\n我的心里\n我的歌声里\nLove lOve loVe lovE\n', '我深深的脑海了\n### 世界之大，为何我们相遇。\n\n你存在\n我深深的脑海了\n我的梦里\n我的心里\n我的歌声里\n\n#### Love lOve loVe lovE', '<p>我深深的脑海了</p>\n<h3><a id="_1"></a>世界之大，为何我们相遇。</h3>\n<p>你存在<br />\n我深深的脑海了<br />\n我的梦里<br />\n我的心里<br />\n我的歌声里</p>\n<h4><a id="Love_lOve_loVe_lovE_9"></a>Love lOve loVe lovE</h4>\n', '2020-08-18 22:11:32', 0);
/*!40000 ALTER TABLE `causerie` ENABLE KEYS */;

-- Dumping structure for table michsta_be_db.essay
DROP TABLE IF EXISTS `essay`;
CREATE TABLE IF NOT EXISTS `essay` (
  `essay_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `essay_content` varchar(500) NOT NULL COMMENT '美句内容',
  `essay_root_in` varchar(100) DEFAULT '未知' COMMENT '句子来源',
  `essay_state` int(11) DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`essay_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8;

-- Dumping data for table michsta_be_db.essay: ~12 rows (大约)
/*!40000 ALTER TABLE `essay` DISABLE KEYS */;
INSERT INTO `essay` (`essay_id`, `essay_content`, `essay_root_in`, `essay_state`) VALUES
	(14, '忽晴忽雨的江湖，祝你有梦为马，随处可栖。', '[阿弥陀佛么么哒]', 1),
	(15, '追风赶月莫停留，平芜尽处是春山。', '[我不]', 0),
	(16, '杂草一样的你，现在摇曳在何方？', '[乖,摸摸头]', 0),
	(17, '如果方向一致，两个命中注定要结伴同行的过客是不会擦肩而过的。', '[ta们最幸福]', 0),
	(18, '日月可鉴，天地为证。', '[来自网络]', 1),
	(20, '去最冷的地方，写最暖的故事。', '[好吗？好的]', 1),
	(21, '追求最适合自己的东西，就是追求的意义。', '[好吗？好的]', 0),
	(22, '所谓的缘分，不过是过去有意无意的选择。', '[乖,摸摸头]', 0),
	(23, '佛就是当下的一念清净心。', '[他们最幸福]', 1),
	(24, '请相信，这个世界上真的有人过着你想要的的生活。忽晴忽雨的江湖，祝你有梦为马，随处可栖。', '[乖,摸摸头]', 0),
	(26, '保持热爱，奔赴大海。', '[dou yin]', 0),
	(27, '你还有多少个20年。', '[出自 iv]', 1);
/*!40000 ALTER TABLE `essay` ENABLE KEYS */;

-- Dumping structure for table michsta_be_db.links
DROP TABLE IF EXISTS `links`;
CREATE TABLE IF NOT EXISTS `links` (
  `links_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `links_name` varchar(20) NOT NULL COMMENT '名称',
  `links_img` varchar(500) NOT NULL COMMENT '头像',
  `links_site` varchar(200) NOT NULL COMMENT '网站链接',
  `links_describe` varchar(500) NOT NULL COMMENT '简介',
  `links_state` int(11) DEFAULT 0 COMMENT '链接状态',
  PRIMARY KEY (`links_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table michsta_be_db.links: ~3 rows (大约)
/*!40000 ALTER TABLE `links` DISABLE KEYS */;
INSERT INTO `links` (`links_id`, `links_name`, `links_img`, `links_site`, `links_describe`, `links_state`) VALUES
	(7, '可可西里', 'https://pic.cnblogs.com/avatar/1409393/20200325103824.png', 'https://www.cnblogs.com/ldl326308/', '所有热爱的事情，都要不留余力。', 0),
	(8, '追梦滴小蜗牛', 'https://pic.cnblogs.com/avatar/1443576/20181023103747.png', 'https://www.cnblogs.com/oukele/', '这个人啥也没说', 0),
	(10, 'chen 胜', 'https://pic.cnblogs.com/avatar/1610861/20190225104318.png', 'https://www.cnblogs.com/chen1005/', '啥也没说', 1);
/*!40000 ALTER TABLE `links` ENABLE KEYS */;

-- Dumping structure for table michsta_be_db.tag
DROP TABLE IF EXISTS `tag`;
CREATE TABLE IF NOT EXISTS `tag` (
  `tag_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '标签ID',
  `tag_name` varchar(30) NOT NULL COMMENT '标签名称',
  `tag_describe` varchar(500) DEFAULT NULL COMMENT '标签描述',
  PRIMARY KEY (`tag_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- Dumping data for table michsta_be_db.tag: ~3 rows (大约)
/*!40000 ALTER TABLE `tag` DISABLE KEYS */;
INSERT INTO `tag` (`tag_id`, `tag_name`, `tag_describe`) VALUES
	(5, 'SpringCloud', '微服务框架'),
	(8, 'MySQL', 'MySQL是一个关系型数据库管理系统，由瑞典MySQL AB 公司开发，属于 Oracle 旗下产品。MySQL 是最流行的关系型数据库管理系统之一，在 WEB 应用方面，MySQL是最好的 RDBMS (Relational Database Management System，关系数据库管理系统) 应用软件之一。'),
	(10, 'Java', '面向对象编程语言');
/*!40000 ALTER TABLE `tag` ENABLE KEYS */;

-- Dumping structure for table michsta_be_db.tag_relation_article
DROP TABLE IF EXISTS `tag_relation_article`;
CREATE TABLE IF NOT EXISTS `tag_relation_article` (
  `tag_relation_article_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '关系表ID',
  `tag_id` int(11) NOT NULL,
  `article_id` varchar(200) NOT NULL,
  PRIMARY KEY (`tag_relation_article_id`),
  KEY `tag_id` (`tag_id`),
  KEY `article_id` (`article_id`),
  CONSTRAINT `tag_relation_article_ibfk_1` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`tag_id`) ON DELETE CASCADE,
  CONSTRAINT `tag_relation_article_ibfk_2` FOREIGN KEY (`article_id`) REFERENCES `article` (`article_id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

-- Dumping data for table michsta_be_db.tag_relation_article: ~12 rows (大约)
/*!40000 ALTER TABLE `tag_relation_article` DISABLE KEYS */;
INSERT INTO `tag_relation_article` (`tag_relation_article_id`, `tag_id`, `article_id`) VALUES
	(1, 5, '325f3613-abed-4233-82a0-5e531938c360'),
	(2, 8, '325f3613-abed-4233-82a0-5e531938c360'),
	(3, 5, '04be9e4c-b891-477a-87c7-ebe728c865dc'),
	(4, 10, '04be9e4c-b891-477a-87c7-ebe728c865dc'),
	(5, 8, '23d9cf51-ad5b-42c8-b5b7-b7486edf0e47'),
	(6, 10, '23d9cf51-ad5b-42c8-b5b7-b7486edf0e47'),
	(7, 8, 'e12c3e91-909b-4f48-a6b8-72dccf98ac0c'),
	(8, 10, 'e12c3e91-909b-4f48-a6b8-72dccf98ac0c'),
	(9, 8, '44a4e755-23b3-49b8-a633-6e23e538d809'),
	(10, 10, '1669ae1e-0917-46cb-bbfa-fe5c02b7af5f'),
	(11, 5, 'b9ac4502-b533-4011-94ab-39c31f990761'),
	(12, 10, 'b9ac4502-b533-4011-94ab-39c31f990761');
/*!40000 ALTER TABLE `tag_relation_article` ENABLE KEYS */;

-- Dumping structure for table michsta_be_db.user
DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_nickname` varchar(30) NOT NULL COMMENT '用户昵称',
  `user_account` varchar(20) NOT NULL COMMENT '登录账号',
  `user_password` varchar(100) NOT NULL COMMENT '登录密码',
  `user_email` varchar(50) DEFAULT NULL COMMENT '邮箱',
  `user_portrait` varchar(100) DEFAULT NULL COMMENT '头像',
  `user_signature` varchar(500) DEFAULT NULL COMMENT '签名',
  `user_create_date` varchar(30) NOT NULL COMMENT '创建时间',
  `user_birthday` varchar(20) NOT NULL COMMENT '用户生日',
  `user_gender` varchar(5) NOT NULL COMMENT '性别',
  `user_address` varchar(100) NOT NULL COMMENT '地址',
  `user_position` varchar(200) DEFAULT NULL COMMENT '职位',
  `user_phone` varchar(20) NOT NULL COMMENT '手机号码',
  `user_qq` varchar(20) NOT NULL COMMENT 'QQ',
  `user_markdown_introduce` longtext DEFAULT NULL COMMENT '个人简介Markdown',
  `user_html_introduce` longtext DEFAULT NULL COMMENT '个人简介Markdown',
  `user_whether_email` int(11) DEFAULT 0 COMMENT '是否展示邮箱',
  `user_whether_gender` int(11) DEFAULT 0 COMMENT '是否展示性别',
  `user_whether_birthday` int(11) DEFAULT 0 COMMENT '是否展示生日',
  `user_whether_address` int(11) DEFAULT 0 COMMENT '是否展示地址',
  `user_whether_position` int(11) DEFAULT 0 COMMENT '是否显示职位',
  `user_whether_phone` int(11) DEFAULT 0 COMMENT '是否显示职位',
  `user_whether_qq` int(11) DEFAULT 0 COMMENT '是否显示QQ',
  `user_state` int(11) DEFAULT 0 COMMENT '状态',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table michsta_be_db.user: ~0 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`user_id`, `user_nickname`, `user_account`, `user_password`, `user_email`, `user_portrait`, `user_signature`, `user_create_date`, `user_birthday`, `user_gender`, `user_address`, `user_position`, `user_phone`, `user_qq`, `user_markdown_introduce`, `user_html_introduce`, `user_whether_email`, `user_whether_gender`, `user_whether_birthday`, `user_whether_address`, `user_whether_position`, `user_whether_phone`, `user_whether_qq`, `user_state`) VALUES
	(1, 'MichstaBe', 'liudilin', '00fbd6d3e86be9c1f3cd8e7f2db17505', '2145131668@qq.com', 'http://cdn.lixsx.net/picture.jpg', '我们所做的每一件事情，都是在向宇宙表达自己的真实身份。 --《与神对话》', '2020-03-22', '1999-12-03', '男', '江西省赣州市', 'RPA实施工程师', '17318071824', '2145131668', '我是一个人\n![QQ图片20170905093952.jpg](http://cdn.lixsx.net/Fu2y-eJ2lWcpGgP1BuWNGt7oTK9d)', '<p>我是一个人<br />\n<img src="http://cdn.lixsx.net/Fu2y-eJ2lWcpGgP1BuWNGt7oTK9d" alt="QQ图片20170905093952.jpg" /></p>\n', 0, 0, 0, 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

-- Dumping structure for table michsta_be_db.website_intro
DROP TABLE IF EXISTS `website_intro`;
CREATE TABLE IF NOT EXISTS `website_intro` (
  `website_intro_id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `website_intro_logo` varchar(200) NOT NULL COMMENT '主页logo',
  `website_intro_main_bg` varchar(200) NOT NULL COMMENT '主页背景图片',
  `website_intro_blog_bg` varchar(200) NOT NULL COMMENT '博客背景图片',
  `website_intro_foreword` varchar(1000) NOT NULL COMMENT '主页前言',
  `website_intro_markdown_describe` longtext NOT NULL COMMENT '网站简介Markdown',
  `website_intro_html_describe` longtext NOT NULL COMMENT '网站简介Html',
  PRIMARY KEY (`website_intro_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- Dumping data for table michsta_be_db.website_intro: ~0 rows (大约)
/*!40000 ALTER TABLE `website_intro` DISABLE KEYS */;
INSERT INTO `website_intro` (`website_intro_id`, `website_intro_logo`, `website_intro_main_bg`, `website_intro_blog_bg`, `website_intro_foreword`, `website_intro_markdown_describe`, `website_intro_html_describe`) VALUES
	(1, 'http://cdn.lixsx.net/website-logo.png', 'http://cdn.lixsx.net/main-bg.jpg', 'http://cdn.lixsx.net/blog-bg.jpg', ' &nbsp;&nbsp; &nbsp;&nbsp; &nbsp;&nbsp;雨后有车驶来 驶过暮色苍白 旧铁皮往南开 恋人已不在 收听浓烟下的 诗歌电台 不动情的咳嗽 至少看起来 归途也还可爱 琴弦少了姿态 再不见那夜里 听歌的小孩 时光匆匆独白 将颠沛磨成卡带 已枯卷的情怀 踏碎成年代 就老去吧 孤独别醒来 你渴望的离开 只是无处停摆 就歌唱吧 眼睛眯起来 而热泪的崩坏 只是没抵达的存在 青春又醉倒在 籍籍无名的怀 靠嬉笑来虚度 聚散得慷慨 辗转却去不到 对的站台 如果漂泊是成长 必经的路牌 你迷醒岁月中 那贫瘠的未来 像遗憾季节里 未结果的爱 弄脏了每一页诗 吻最疼痛的告白 而风声吹到这 已不需要释怀 就老去吧 孤独别醒来 你渴望的离开 只是无处停摆 就歌唱吧 眼睛眯起来 而热泪的崩坏 只是没抵达的存在 就甜蜜地忍耐 繁星润湿窗台 光影跳动着像在 困倦里说爱 再无谓的感慨 以为明白 梦倒塌的地方 今已爬满青苔\n<p style="text-align:right;">-- 《理想三旬》<p>', '### About MichstaBe^归途^\n2020-07-07\n<br/>\n\n#### 站点起源\n\n站点的诞生可追溯到2019年10月。那时候因为什么我已经忘记了，只记得在浏览网页时突然进入到一个个人站点，我，被深深的吸引了，这感觉无法用语言形容。我把这个站点仔仔细细的看了一遍，得知站点竟诞生于2003年，我顿时觉得不可思议，2003年那年我才4岁，在那个电脑都不普及的时代竟然诞生了这么不可思议的站点。站点记录了“站主”很多有意思的事情，我看着文章时回忆瞬间喷涌上来。有一些美好的记忆如果我不记录下来，是不是就真的会随风消逝、无影无踪...在IT行业走一遭总要留下点什么，于是我下定决心做一件有意义的事情，开发属于我自己的个人站点，于是从那时开始设计、开发个人的站点。中间几经波折于2020年4月，第一版站点发布，取名为[yuni]，后因项目考虑不周全、界面不美观等问题，在第一版的基础上重新开发了第二版，诞生于2020年7月17日。\n<br/>\n#### 管理员\n12月3日 射手座，LIK-。\n生于虔诚，2017年异乡求学，2019年2月22日开始了人生的第一份工作。\n<br/>\n曾经是篮球爱好者，最喜欢的球星是KoBe，幻想过在球场上像KoBe一样做出后仰跳投的动作，曾因KoBe励志成为一个篮球高手。现在不但没有成为篮球高手，连篮球都几年没碰过了。不过我依然热爱篮球~ 热爱运动~\n![1597651334243.jpg](http://cdn.lixsx.net/FqB5FPL6jjoLEvpdI7sr-jBRSxVA)![科比高清图片_彼岸图网.jpg](http://cdn.lixsx.net/FmFuB2u6lA8xp2A4WEqBQ9k2s3ST)\n现已毕业工作一年零5个月，在一家公司从事RPA实施工作。工作一年多惊觉健康良好的作息与爱好非常重要，所以闲暇时间想保持阅读、学编程，偶尔出去运动运动，空闲时间喜欢看动漫、看有意义的电影、听各种风格的歌...\n<br/>\n\n不排斥热闹的场合，但更倾向于独处。独处会想的比较多，对未来的一些规划以及对自己目前的反思。\n<br/>\n\n\n', '<h3><a id="About_MichstaBe_0"></a>About MichstaBe<sup>归途</sup></h3>\n<p>2020-07-07<br />\n<br/></p>\n<h4><a id="_4"></a>站点起源</h4>\n<p>站点的诞生可追溯到2019年10月。那时候因为什么我已经忘记了，只记得在浏览网页时突然进入到一个个人站点，我，被深深的吸引了，这感觉无法用语言形容。我把这个站点仔仔细细的看了一遍，得知站点竟诞生于2003年，我顿时觉得不可思议，2003年那年我才4岁，在那个电脑都不普及的时代竟然诞生了这么不可思议的站点。站点记录了“站主”很多有意思的事情，我看着文章时回忆瞬间喷涌上来。有一些美好的记忆如果我不记录下来，是不是就真的会随风消逝、无影无踪…在IT行业走一遭总要留下点什么，于是我下定决心做一件有意义的事情，开发属于我自己的个人站点，于是从那时开始设计、开发个人的站点。中间几经波折于2020年4月，第一版站点发布，取名为[yuni]，后因项目考虑不周全、界面不美观等问题，在第一版的基础上重新开发了第二版，诞生于2020年7月17日。<br />\n<br/></p>\n<h4><a id="_8"></a>管理员</h4>\n<p>12月3日 射手座，LIK-。<br />\n生于虔诚，2017年异乡求学，2019年2月22日开始了人生的第一份工作。<br />\n<br/><br />\n曾经是篮球爱好者，最喜欢的球星是KoBe，幻想过在球场上像KoBe一样做出后仰跳投的动作，曾因KoBe励志成为一个篮球高手。现在不但没有成为篮球高手，连篮球都几年没碰过了。不过我依然热爱篮球~ 热爱运动~<br />\n<img src="http://cdn.lixsx.net/FqB5FPL6jjoLEvpdI7sr-jBRSxVA" alt="1597651334243.jpg" /><img src="http://cdn.lixsx.net/FmFuB2u6lA8xp2A4WEqBQ9k2s3ST" alt="科比高清图片_彼岸图网.jpg" /><br />\n现已毕业工作一年零5个月，在一家公司从事RPA实施工作。工作一年多惊觉健康良好的作息与爱好非常重要，所以闲暇时间想保持阅读、学编程，偶尔出去运动运动，空闲时间喜欢看动漫、看有意义的电影、听各种风格的歌…<br />\n<br/></p>\n<p>不排斥热闹的场合，但更倾向于独处。独处会想的比较多，对未来的一些规划以及对自己目前的反思。<br />\n<br/></p>\n');
/*!40000 ALTER TABLE `website_intro` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
