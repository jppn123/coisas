from marshmallow import Schema, fields
from schemas.storeSchema import PlainStoreSchema
from schemas.itemSchema import ItemSchema, PlainItemSchema

class PlainTagSchema(Schema):
    id = fields.Int(dump_only=True)
    name = fields.Str()

class TagSchema(PlainTagSchema):
    store_id = fields.Int(load_only=True)
    store = fields.Nested(PlainStoreSchema(), dump_only=True)
    items = fields.List(fields.Nested(PlainItemSchema()), dump_only=True)
    
class TagAndItemSchema(Schema):
    message = fields.Str()
    item = fields.Nested(ItemSchema)
    tag = fields.Nested(TagSchema)