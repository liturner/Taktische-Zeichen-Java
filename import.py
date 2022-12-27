import io
import os
import shutil

rawRoot = "src/raw/"
resourceRoot = "src/main/resources/de/turnertech/taktische_zeichen/"

packageMap = {
    "Bundeswehr_Einheiten" : "einheiten/bundeswehr/",
    "Bundeswehr_Fahrzeuge" : "fahrzeuge/bundeswehr/",
    "Bundeswehr_Personen" : "personen/bundeswehr/",
    "Einheiten" : "einheiten/",
    "Einrichtungen" : "einrichtungen/",
    "Fahrzeuge" : "fahrzeuge/",
    "Fernmeldewesen" : "fernmeldewesen/",
    "Feuerwehr_Einheiten" : "einheiten/feuerwehr/",
    "Feuerwehr_Fahrzeuge" : "fahrzeuge/feuerwehr/",
    "Feuerwehr_Gebäude" : "gebäude/feuerwehr/",
    "Feuerwehr_Personen" : "personen/feuerwehr/",
    "Führungsstellen" : "führungsstellen/",
    "Gebäude" : "gebäude/",
    "Gefahren" : "gefahren/",
    "Katastrophenschutz_Einheiten" : "einheiten/katastrophenschutz/",
    "Kommunal_Fahrzeuge" : "fahrzeuge/kommunal/",
    "Maßnahmen" : "maßnahmen/",
    "Personen" : "personen/",
    "Polizei_Einheiten" : "einheiten/polizei/",
    "Polizei_Fahrzeuge" : "fahrzeuge/polizei/",
    "Rettungswesen_Einheiten" : "einheiten/rettungswesen/",
    "Rettungswesen_Einrichtungen" : "einrichtungen/rettungswesen/",
    "Rettungswesen_Fahrzeuge" : "fahrzeuge/rettungswesen/",
    "Rettungswesen_Personen" : "personen/rettungswesen/",
    "Schäden" : "schäden",
    "Schadenskonten/gelb" : "schadenskonten/gelb/",
    "Schadenskonten/rot" : "schadenskonten/rot/",
    "Schadenskonten/weiß" : "schadenskonten/weiß/",
    "Sonstiges" : "sonstiges/",
    "THW_Einheiten" : "einheiten/thw/",
    "THW_Fahrzeuge" : "fahrzeuge/thw/",
    "THW_Gebäude" : "gebäude/thw/",
    "THW_Personen" : "personen/thw/",
    "Wasserrettung_Einheiten" : "einheiten/wasserrettung/",
    "Zoll_Einheiten" : "einheiten/zoll/",
    "Zoll_Fahrzeuge" : "fahrzeuge/zoll/"
}

for filename in os.listdir(resourceRoot):
    file_path = os.path.join(resourceRoot, filename)
    try:
        if os.path.isfile(file_path) or os.path.islink(file_path):
            os.unlink(file_path)
        elif os.path.isdir(file_path):
            shutil.rmtree(file_path)
    except Exception as e:
        print('Failed to delete %s. Reason: %s' % (file_path, e))


for key, value in packageMap.items():
    shutil.copytree(rawRoot + key, resourceRoot + value, dirs_exist_ok=True)
        
with io.open(resourceRoot + 'index', mode="w", encoding="utf-8") as indexFile:
    for root, dirs, files in os.walk(resourceRoot):
        for file in files:
            path = root + '/' + file
            path = path.replace('\\', '/')
            path = path[len("src/main/resources"):]
            indexFile.write(path + '\n')

print("fin")