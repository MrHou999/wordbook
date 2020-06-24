# Host: localhost  (Version 5.7.27)
# Date: 2020-06-24 11:15:49
# Generator: MySQL-Front 6.0  (Build 2.20)


#
# Structure for table "wordbook"
#

DROP TABLE IF EXISTS `wordbook`;
CREATE TABLE `wordbook` (
  `wordId` int(11) NOT NULL DEFAULT '0',
  `word` varchar(100) NOT NULL DEFAULT '',
  `meaning` varchar(100) NOT NULL DEFAULT '',
  PRIMARY KEY (`wordId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

#
# Data for table "wordbook"
#

