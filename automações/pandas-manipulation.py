import pandas as pd 
from styleframe import StyleFrame

# criação de um dataframe a partir de um dicionario
lis_val_datas = [1034004001234532, 10340040012345332, 10340040012345232]
lis_per_pes = ["carlos", "andre", "caio"]
# lis_lojas = [2, 3, 4]
df = pd.DataFrame({'valorizações das datas': lis_val_datas, 
                   'percurso das pessoas': lis_per_pes,
                #    'lojas onde estão': lis_lojas
                   })
pd.set_option('float_format', '{:.0f}'.format)
df.to_csv('ex.csv', index=False, header=False)

# usado para setar o tamanho da celula no excel
# excel_writer = StyleFrame.ExcelWriter('example.xlsx')
# # adiciona o espaço lateral em uma celula de 35.3 de largura
# sf = StyleFrame(df)
# sf.set_column_width(columns=['lojas onde estão', 'percurso das pessoas', 'valorizações das datas'], width=35.3)
# sf.to_excel(excel_writer=excel_writer, sheet_name='tabela 1')
# excel_writer.close()

