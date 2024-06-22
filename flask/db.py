from flask_sqlalchemy import SQLAlchemy

db = SQLAlchemy()
stores = {} #id, name
items = {} #id, name, price, store_id