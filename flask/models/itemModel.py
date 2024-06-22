from db import db 

class ItemModel(db.Model):
    __tablename__  = "items"
    
    id = db.Column(db.Integer, primary_key=True)
    name = db.Column(db.String(80), unique=True, nullable=False)
    price = db.Column(db.Float(precision=2), unique=False, nullable=False)
    # one to many example
    store_id = db.Column(db.Intenger, db.ForeignKey("stores.id"), unique=False, nullable=False)
    # referencia o item items da classe StoreModel
    store = db.relationship("StoreModel", back_populates="items")
    
    # many to many, precisa criar uma tabela aux, secondary= o __tablename__ da tabela auxiliar 
    tags = db.relationship("TagModel", back_populates="items", secondary="items_tags")