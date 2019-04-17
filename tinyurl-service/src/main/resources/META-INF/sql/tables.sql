create table TinyUrl_TinyURL (
	tinyURLId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	classNameId LONG,
	classPK LONG,
	code_ VARCHAR(75) null,
	visible BOOLEAN
);