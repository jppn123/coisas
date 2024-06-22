from selenium.webdriver import Firefox
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from time import sleep

url = 'https://www.google.com.br/maps/dir///@-3.8046207,-38.7555035,11z/data=!4m2!4m1!3e0?entry=ttu'
xpFirstLabel = '//div[@id="sb_ifc50"]/input'
xpSecLabel = '//div[@id="sb_ifc51"]/input'
xpKms = '//div[@class="ivN21e tUEI8e fontBodyMedium"]/div'
xpFindButton = "//*[@id='directions-searchbox-1']/button[@class='mL3xi']"
xpChangeRoles = '//*[@class="PLEQOe reverse"]'
xpCars = '//*[@data-tooltip="Carro"]'
xpBikes = '//*[@data-tooltip="Motocicleta"]'

def kmConverter(kms):
    list_kms = []
    for km in kms:
        list_kms.append(km.text.replace(',', '.').split(' '))
    kms.clear()
    for x in list_kms:
        kms.append(float(x[0]))
    list_kms.clear()
    return min(kms)

def secToMany(driver, key):
    driver.find_element(By.XPATH, xpSecLabel).send_keys(key)
    driver.find_element(By.XPATH, xpFindButton).click()
    sleep(3)
    kms = driver.find_elements(By.XPATH, xpKms)
    return kms

cityList = ["north shopping fortaleza", "north shopping parangaba", "riomar fortaleza", "riomar kennedy"]
kmList = []
startPoint = "condominio green garden"
gasValue = round(5.87/12, 4) # 0.4892


driver = Firefox()
driver.maximize_window()
driver.get(url)
sleep(2)
driver.find_element(By.XPATH, xpFirstLabel).send_keys(startPoint)
for x in range(len(cityList)):
    kms = secToMany(driver, cityList[x])
    km = kmConverter(kms)
    kmList.append(km)
    print('menor km atual:', km, 'km')
    print('soma kms:', round(sum(kmList), 2), 'km')
    if x != (len(cityList) - 1):
        driver.find_element(By.XPATH, xpChangeRoles).click()
        driver.find_element(By.XPATH, xpSecLabel).click()

driver.close()


print(f'final: {round(sum(kmList) * gasValue, 2)}R$')

'''
calculo da gasolina/km
custo médio da gasolina / 12km
'''