import io
import os
import shutil

rawRoot = "de.turnertech.tz/src/raw/"
resourceRoot = "de.turnertech.tz/src/main/resources/de/turnertech/tz/"

packageMap = {
    "Bundeswehr_Einheiten" : ["einheiten/bundeswehr/", "bw,einheiten"],
    "Bundeswehr_Fahrzeuge" : ["fahrzeuge/bundeswehr/", "bw"],
    "Bundeswehr_Personen" : ["personen/bundeswehr/", "bw"],
    "Einheiten" : ["einheiten/", "einheiten"],
    "Einrichtungen" : ["einrichtungen/", ""],
    "Fahrzeuge" : ["fahrzeuge/", ""],
    "Fernmeldewesen" : ["fernmeldewesen/", ""],
    "Feuerwehr_Einheiten" : ["einheiten/feuerwehr/", "fw"],
    "Feuerwehr_Fahrzeuge" : ["fahrzeuge/feuerwehr/", "fw"],
    "Feuerwehr_Gebäude" : ["gebäude/feuerwehr/", "fw"],
    "Feuerwehr_Personen" : ["personen/feuerwehr/", "fw"],
    "Führungsstellen" : ["führungsstellen/", ""],
    "Gebäude" : ["gebäude/", ""],
    "Gefahren" : ["gefahren/", ""],
    "Katastrophenschutz_Einheiten" : ["einheiten/katastrophenschutz/", ""],
    "Kommunal_Fahrzeuge" : ["fahrzeuge/kommunal/", ""],
    "Maßnahmen" : ["maßnahmen/", ""],
    "Personen" : ["personen/", ""],
    "Polizei_Einheiten" : ["einheiten/polizei/", "einheiten"],
    "Polizei_Fahrzeuge" : ["fahrzeuge/polizei/", ""],
    "Rettungswesen_Einheiten" : ["einheiten/rettungswesen/", "einheiten"],
    "Rettungswesen_Einrichtungen" : ["einrichtungen/rettungswesen/", ""],
    "Rettungswesen_Fahrzeuge" : ["fahrzeuge/rettungswesen/", ""],
    "Rettungswesen_Personen" : ["personen/rettungswesen/", ""],
    "Schäden" : ["schäden", ""],
    "Schadenskonten/gelb" : ["schadenskonten/gelb/", ""],
    "Schadenskonten/rot" : ["schadenskonten/rot/", ""],
    "Schadenskonten/weiß" : ["schadenskonten/weiß/", ""],
    "Sonstiges" : ["sonstiges/", ""],
    "THW_Einheiten" : ["einheiten/thw/", "thw,einheiten"],
    "THW_Fahrzeuge" : ["fahrzeuge/thw/", "thw"],
    "THW_Gebäude" : ["gebäude/thw/", "thw,gebäude"],
    "THW_Personen" : ["personen/thw/", "thw,personen"],
    "Wasserrettung_Einheiten" : ["einheiten/wasserrettung/", ""],
    "Zoll_Einheiten" : ["einheiten/zoll/", "zoll"],
    "Zoll_Fahrzeuge" : ["fahrzeuge/zoll/", "zoll"]
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

if os.path.exists(resourceRoot + 'index.properties'):
    os.remove(resourceRoot + 'index.properties')

id = 1
for key, value in packageMap.items():
    shutil.copytree(rawRoot + key, resourceRoot + value[0], dirs_exist_ok=True)

    with io.open(resourceRoot + 'index', mode="a", encoding="utf-8") as indexFile:
        for root, dirs, files in os.walk(resourceRoot + value[0]):
            for file in files:
                if(file == "index.properties"):
                    continue
                path = root + '/' + file
                path = path.replace('\\', '/')
                path = path.replace('//', '/')
                path = path[len("de.turnertech.tz/src/main/resources"):]
                indexFile.write(path + "," + value[1] + '\n')
                id += 1

print("fin")