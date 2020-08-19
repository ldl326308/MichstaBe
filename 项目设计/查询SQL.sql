SELECT * FROM 
(
SELECT essay.essay_id, essay.essay_content,essay.essay_root_in, essay_state,
case 
when essay_state = 0 then '显示'
when essay_state = 1 then '隐藏'
END essay_state_alias
FROM essay 
)
AS a WHERE a.essay_content LIKE '%你%' OR a.essay_root_in LIKE '%梦%' OR a.essay_state_alias LIKE '%正常%'


SELECT * FROM links;

SELECT * FROM 
(
select links_id, links_name, links_img, links_site, links_describe, links_state,
case 
when links_state = 0 then '显示'
when links_state = 1 then '隐藏'
END links_state_alias
from links
) AS a WHERE a.links_name LIKE '' OR a.links_site LIKE '' OR a.links_describe LIKE '' a.links_state_alias LIKE '';



INSERT INTO `links`(`links_name`, `links_img`, `links_site`, `links_describe`) 
	VALUES ('可可西里', 'https://pic.cnblogs.com/avatar/1409393/20200325103824.png', 'https://www.cnblogs.com/ldl326308/', '这是一个优秀的博客网站...');


DELETE FROM tag_relation_article WHERE tag_relation_article.article_id IN (SELECT article_id FROM article);	
	
DELETE article, tag_relation_article FROM tag_relation_article INNER JOIN article ON tag_relation_article.article_id = article.article_id
WHERE article.article_id = 1;	
	
	
SELECT * FROM article;	

SELECT * FROM tag_relation_article;

SELECT * FROM tag;


-- 后台管理查询
SELECT article.article_id, article.article_alias, article.article_title, article.article_basic, article.article_html_content, article.article_markdown_content, article.article_create_date, article.article_last_update_date,
article.article_protect, article.article_stick, tag_relation_article.tag_relation_article_id, tag_relation_article.tag_id, tag.tag_name, tag.tag_describe, article.article_state,
case 
when article.article_state = 0 then '显示'
when article.article_state = 1 then '隐藏'
END article_state_alias,
case 
when article.article_protect = '' then '未加密'
when article.article_protect != '' then '加密'
END article_protect_alias
FROM article LEFT JOIN tag_relation_article ON article.article_id = tag_relation_article.article_id LEFT JOIN tag ON tag.tag_id = tag_relation_article.tag_id
ORDER BY article.article_stick DESC;

-- 根据alias查询下一条记录
SELECT article.article_id, article.article_alias, article.article_title, article.article_basic, article.article_html_content, article.article_markdown_content, article.article_create_date, article.article_last_update_date,
article.article_protect, article.article_stick, article.article_state,
case 
when article.article_state = 0 then '显示'
when article.article_state = 1 then '隐藏'
END article_state_alias,
case 
when article.article_protect = '' then '未加密'
when article.article_protect != '' then '加密'
END article_protect_alias
FROM article WHERE 
ORDER BY article.article_stick DESC;
	
	
-- 后台管理模糊查询

SELECT * FROM 
(
SELECT article.article_id, article.article_alias, article.article_title, article.article_basic, article.article_html_content, article.article_markdown_content, article.article_create_date, article.article_last_update_date,
article.article_protect, article.article_stick, tag_relation_article.tag_relation_article_id, tag_relation_article.tag_id, tag.tag_name, tag.tag_describe, article.article_state,
case 
when article.article_state = 0 then '显示'
when article.article_state = 1 then '隐藏'
END article_state_alias,
case 
when article.article_protect = '' then '未加密'
when article.article_protect != '' then '加密'
END article_protect_alias
FROM article LEFT JOIN tag_relation_article ON article.article_id = tag_relation_article.article_id LEFT JOIN tag ON tag.tag_id = tag_relation_article.tag_id
) a
WHERE a.article_id IN (
-- 查询存在关键字的记录 article_id
SELECT a.article_id FROM
(  
SELECT article.*,
case 
when article.article_state = 0 then '显示'
when article.article_state = 1 then '隐藏'
END article_state_alias,
case 
when article.article_protect = '' then '未加密'
when article.article_protect != '' then '加密'
END article_protect_alias
FROM article 
) a WHERE upper(a.article_title) LIKE UPPER('%java%') OR upper(a.article_markdown_content) LIKE UPPER('%java%')  OR upper(a.article_state_alias) LIKE UPPER('%java%') OR a.article_protect_alias = 'java'
) OR a.tag_id IN (	
-- 模糊查询存在关键子的 tag_id
SELECT tag.tag_id FROM tag WHERE  upper(tag.tag_name) = UPPER('java')
) OR a.article_id IN (
SELECT tag_relation_article.article_id FROM tag_relation_article WHERE tag_relation_article.tag_id IN (SELECT tag.tag_id FROM tag WHERE upper(tag.tag_name) LIKE UPPER('%java%'))	
);	
	
	
	
DELETE FROM article  WHERE article.article_id = 'b041df95-c38e-46af-ae79-f64bb83eef43';



# 通过 article_alias 查询一条记录
SELECT article.article_id, article.article_alias, article.article_title, article.article_basic, article.article_html_content, article.article_markdown_content, article.article_create_date, article.article_last_update_date,
article.article_protect, article.article_stick, tag_relation_article.tag_relation_article_id, tag_relation_article.tag_id, tag.tag_name, tag.tag_describe, article.article_state
FROM article LEFT JOIN tag_relation_article ON article.article_id = tag_relation_article.article_id LEFT JOIN tag ON tag.tag_id = tag_relation_article.tag_id
WHERE article.article_alias = '164.html';



SELECT * FROM `tag_relation_article` WHERE `tag_relation_article`.article_id = '6de01bc1-ee22-4a5d-8672-ddab4e111fd3';


SELECT * FROM tag;
SELECT * FROM tag_relation_article;
SELECT * FROM article;

--
SELECT article.article_alias, article.article_title FROM article ORDER BY article.article_create_date DESC;
		
-- 模糊查询 causerie
SELECT * FROM
(	
	SELECT *,
	case 
		when causerie.causerie_state = 0 then '显示'
		when causerie.causerie_state = 1 then '隐藏'
	END causerie_state_alias
	FROM causerie 
) cau
WHERE cau.causerie_title LIKE '%测试%' OR cau.causerie_basic LIKE '%测试%' OR cau.causerie_state_alias LIKE '%隐藏%';	

-- 根据 causerie_alias 查询记录
SELECT * FROM causerie WHERE causerie.causerie_alias = '';

-- 查询所有 causerie 记录，按 causerie_create_time 排序
SELECT * FROM causerie ORDER BY causerie.causerie_create_time DESC;

-- 获取最新发布的记录
SELECT * FROM causerie ORDER BY causerie.causerie_create_time DESC LIMIT 1;


SELECT * FROM `user`;

select * from `user` LIMIT 1;

-- 查询记录，记录 user_password 设置为空
SELECT `user_id`, `user_nickname`, `user_account`, `user_email`, `user_portrait`, `user_signature`, `user_create_date`, `user_birthday`, `user_gender`, `user_address`, `user_position`,
  `user_phone`, `user_qq`, `user_markdown_introduce`, `user_html_introduce`, `user_whether_email`, `user_whether_gender`, `user_whether_birthday`, `user_whether_address`, `user_whether_position`,
  `user_whether_phone`, `user_whether_qq`, `user_state`, '' AS `user_password` FROM `user` LIMIT 1;



-- 前端访问，只显示简单信息
SELECT article.article_id, article.article_alias, article.article_title, article.article_create_date, 
article.article_protect, article.article_stick, tag_relation_article.tag_relation_article_id, tag_relation_article.tag_id, tag.tag_name, tag.tag_describe, article.article_state,
case 
	when article.article_protect = '' then article.article_basic
	when article.article_protect != '' then '此文章被加密徐密码访问...'
END 'article_basic'
FROM article LEFT JOIN tag_relation_article ON article.article_id = tag_relation_article.article_id LEFT JOIN tag ON tag.tag_id = tag_relation_article.tag_id
ORDER BY article.article_stick,article.article_create_date DESC;


SELECT * FROM article;


SELECT * FROM `user`;

INSERT INTO `website_intro`(`website_intro_logo`, `website_intro_main_bg`, `website_intro_blog_bg`,
 `website_intro_foreword`, `website_intro_markdown_describe`, `website_intro_html_describe`)
VALUES ('http://cdn.lixsx.net/website-logo.png', 'http://cdn.lixsx.net/main-bg.jpg', 'http://cdn.lixsx.net/blog-bg.jpg', '这是前言', '* Markdown', '<strong>Markdown</strong>');

SELECT * FROM `website_intro` LIMIT 1;



























	
	