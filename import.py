import io
import os
import shutil

rawRoot = "de.turnertech.tz/src/raw/"
resourceRoot = "de.turnertech.tz/src/main/resources/de/turnertech/tz/symbol/"

packageMap = {
    "Bundeswehr_Einheiten" : ["einheiten/bundeswehr/", "bw,einheiten"],
    "Bundeswehr_Fahrzeuge" : ["fahrzeuge/bundeswehr/", "bw,fahrzeuge"],
    "Bundeswehr_Personen" : ["personen/bundeswehr/", "bw,personen"],
    "Einheiten" : ["einheiten/", "einheiten"],
    "Einrichtungen" : ["einrichtungen/", "einrichtungen"],
    "Fahrzeuge" : ["fahrzeuge/", "fahrzeuge"],
    "Fernmeldewesen" : ["fernmeldewesen/", "fernmeldewesen"],
    "Feuerwehr_Einheiten" : ["einheiten/feuerwehr/", "fw,einheiten"],
    "Feuerwehr_Fahrzeuge" : ["fahrzeuge/feuerwehr/", "fw,fahrzeuge"],
    "Feuerwehr_Gebäude" : ["gebäude/feuerwehr/", "fw,gebäude"],
    "Feuerwehr_Personen" : ["personen/feuerwehr/", "fw,personen"],
    "Führungsstellen" : ["führungsstellen/", "führungsstellen"],
    "Gebäude" : ["gebäude/", "gebäude"],
    "Gefahren" : ["gefahren/", "gefahren"],
    "Katastrophenschutz_Einheiten" : ["einheiten/katastrophenschutz/", "katastrophenschutz,einheiten"],
    "Kommunal_Fahrzeuge" : ["fahrzeuge/kommunal/", "fahrzeuge"],
    "Maßnahmen" : ["maßnahmen/", "maßnahmen"],
    "Personen" : ["personen/", "personen"],
    "Polizei_Einheiten" : ["einheiten/polizei/", "polizei,einheiten"],
    "Polizei_Fahrzeuge" : ["fahrzeuge/polizei/", "polizei,fahrzeuge"],
    "Rettungswesen_Einheiten" : ["einheiten/rettungswesen/", "rettungswesen,einheiten"],
    "Rettungswesen_Einrichtungen" : ["einrichtungen/rettungswesen/", "rettungswesen,einrichtungen"],
    "Rettungswesen_Fahrzeuge" : ["fahrzeuge/rettungswesen/", "rettungswesen,fahrzeuge"],
    "Rettungswesen_Personen" : ["personen/rettungswesen/", "rettungswesen,personen"],
    "Schäden" : ["schäden", "schäden"],
    "Schadenskonten/gelb" : ["schadenskonten/gelb/", "schadenskonten"],
    "Schadenskonten/rot" : ["schadenskonten/rot/", "schadenskonten"],
    "Schadenskonten/weiß" : ["schadenskonten/weiß/", "schadenskonten"],
    "Sonstiges" : ["sonstiges/", "sonstiges"],
    "THW_Einheiten" : ["einheiten/thw/", "thw,einheiten"],
    "THW_Fahrzeuge" : ["fahrzeuge/thw/", "thw,fahrzeuge"],
    "THW_Gebäude" : ["gebäude/thw/", "thw,gebäude"],
    "THW_Personen" : ["personen/thw/", "thw,personen"],
    "Wasserrettung_Einheiten" : ["einheiten/wasserrettung/", "wasserrettung,einheiten"],
    "Zoll_Einheiten" : ["einheiten/zoll/", "zoll,einheiten"],
    "Zoll_Fahrzeuge" : ["fahrzeuge/zoll/", "zoll,fahrzeuge"]
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