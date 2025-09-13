from GenericFile import TextUNICODE, XMLFile , BMP
import xml.etree.ElementTree as xml

def is_uniform(frecv1 , frecv2 , total):
    if(total < 2):
        return True
    expected = total/2
    diff1 = abs(frecv1 - expected)/expected
    diff2 = abs(frecv2 - expected)/expected
    threshold=0.1
    return diff1 <= threshold and diff2 <= threshold # true if the diference is under 10%

def getFileType(content):
    frecv_ascii_valid =0
    frecv_ascii_invalid=0
    frecv_unicode = 0
    nr = 0
    freq_list = [0] * 256

    for byte in content:
        nr +=1
        character = chr(byte)

        ascii_val = ord(character)
        freq_list[ascii_val] += 1
        if( 9 <=ascii_val <= 10 or
                (ascii_val == 13) or
                (32 <=ascii_val <= 127)):
            frecv_ascii_valid += 1
        else:
            frecv_ascii_invalid += 1
        if ascii_val == 48: # =0
            frecv_unicode +=1

    file = None
    if frecv_unicode > (30/100*nr):
         file = TextUNICODE()
         file.frecvente = freq_list

    elif is_uniform(frecv_ascii_valid,frecv_ascii_invalid,nr):
        file = BMP()
        file.frecvente = freq_list

    else:
        file = XMLFile()
        file.frecvente = freq_list
        # root = xml.fromstring(content)
        # file.first_tag = root[0].tag if len(root) > 0 else None

    return file



