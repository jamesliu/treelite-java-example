import sys
import os
sys.path.append(os.path.join(os.path.dirname(os.path.abspath(__file__)),
                             'treelite/python'))
import treelite
model = treelite.Model.load('/tmp/bst-model.bin', 'xgboost')
model.compile(dirpath='./model', compiler='ast_java')
