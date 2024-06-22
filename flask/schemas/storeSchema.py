from marshmallow import Schema, fields
from schemas.itemSchema import PlainItemSchema
from schemas.tagSchema import PlainTagSchema

# aqui na pasta schemas ficam as restrições que as requisições 'store', nesse caso, precisam ter
class PlainStoreSchema(Schema):
    id = fields.Str(dump_only=True)
    name = fields.Str(required=True)

# está separado os schemas aninhados para não gerar aninhamento infinito
class StoreSchema(PlainStoreSchema):
    item = fields.List(fields.Nested(PlainItemSchema(), dump_only=True))
    tags = fields.List(fields.Nested(PlainTagSchema()), dump_only=True)