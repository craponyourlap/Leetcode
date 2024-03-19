def initializeTags():
    tags = []
    while True:
        tag = input()
        if tag == 'no':
            break
        tags.append(tag)
    return tags

def initializeSkills():
    skills = []
    while True:
        skill = input()
        if skill == 'no':
            break
        skills.append(skill)
    return skills

def manipulate(tags, skills):
    for tag in tags:
        tag_len = len(tag)
        for skill in skills:
            if skill in tag:
                tag_len -= len(skill)
        if tag_len <= 0:
            print('TRUE')
        else:
            print('FALSE')

def manipul(skills):
    while True:
        tag = input()
        if tags == 'no':
            break
        tag_len = len(tag)
        for skill in skills:
            if skill in tag:
                tag_len -= len(skill)
        if tag_len <= 0:
            print('TRUE')
        else:
            print('FALSE')

    
if __name__ == '__main__':
    print('Paste tags of each problem in TSV format')
    tags = initializeTags()
    print('Paste the skills acquired/to be acquired in TSV format')
    skills = initializeSkills()
    print('Result:')
    manipulate(tags, skills)

