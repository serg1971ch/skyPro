-- liquibase formated sql

-- changeset author:1
CREATE TABLE notifications (
                           id SERIAL NOT NULL PRIMARY KEY,
                           chat_id bigint NOT NULL,
                           notification_date timestamp NOT NULL,
                           message text NOT NULL,
                           status varchar default 'SCHEDULED',
                           notification_sent timestamp
);


-- changeset author:2
CREATE INDEX notifications_date_index ON notifications (notification_date) WHERE status 'SCHEDULED';